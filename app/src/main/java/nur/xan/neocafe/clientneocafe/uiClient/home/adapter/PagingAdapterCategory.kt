package nur.xan.neocafe.clientneocafe.uiClient.home.category

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import nur.xan.neocafe.clientneocafe.R
import nur.xan.neocafe.clientneocafe.databinding.ItemCategoryBinding
import nur.xan.neocafe.clientneocafe.interfaces.IClickListnearCategoryInfo
import nur.xan.neocafe.clientneocafe.models.test.TestCategory

class PagingAdapterCategory(private val mIClickListnear: IClickListnearCategoryInfo) :
    PagingDataAdapter<TestCategory, PagingAdapterCategory.MyViewHolder>(diffCallback) {

    private var selectedPosition = 0
    lateinit var context: Context

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<TestCategory>() {
            override fun areItemsTheSame(oldItem: TestCategory, newItem: TestCategory): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TestCategory, newItem: TestCategory): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = getItem(position)

        if (position == selectedPosition) {
            holder.binding.idCardView.setBackgroundResource(R.drawable.button_background2)
            // Установка цвета текста в TextView
            holder.binding.textTitle.setTextColor(ContextCompat.getColor(context, R.color.white))
        } else {
            holder.binding.idCardView.setBackgroundResource(0)
            holder.binding.textTitle.setTextColor(ContextCompat.getColor(context, R.color.gray2))
        }

//        if (position == 1){
//            holder.binding.idCardView.setBackgroundResource(R.drawable.button_background2)
//        }

//        Glide.with(context).load(R.drawable.test_svg_category2)
//            .thumbnail(Glide.with(context).load(R.drawable.loader2))
//            .fitCenter()
//            .into(holder.binding.itemHomeImages)

        holder.binding.textTitle.text = currentItem!!.title

        // Изменяем цвет фона, если текущий элемент соответствует выбранному индексу
        holder.binding.idCardView.setBackgroundResource(
            if (position == selectedPosition) {
                R.drawable.button_background2
            } else {
                R.drawable.fon_white
            }
        )


        holder.binding.rowCostom.setOnClickListener {
            mIClickListnear.clickListener(position, currentItem.title)
            selectItem(position)
        }
    }

    inner class MyViewHolder(val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root)

    @SuppressLint("NotifyDataSetChanged")
    fun selectItem(position: Int) {
        selectedPosition = position
        notifyDataSetChanged()
    }

}
