package nur.xan.neocafe.clientneocafe.uiClient.home.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import nur.xan.neocafe.clientneocafe.R
import nur.xan.neocafe.clientneocafe.databinding.ItemAllBinding
import nur.xan.neocafe.clientneocafe.interfaces.IClickListnearOnClick
import nur.xan.neocafe.clientneocafe.models.test.TestModels
import kotlin.collections.ArrayList

class AdapterRecomend(private val mIClickListnear: IClickListnearOnClick) :

    RecyclerView.Adapter<AdapterRecomend.TovarViewHolder>() {
    lateinit var context: Context

    var listTovar = ArrayList<TestModels>()

    class TovarViewHolder(val binding: ItemAllBinding) : RecyclerView.ViewHolder(binding.root)

    @SuppressLint("NotifyDataSetChanged")
    fun deleteMyEducations(position: Int) {
        listTovar.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, listTovar.size)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TovarViewHolder {
        val binding = ItemAllBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return TovarViewHolder(binding)
    }

    @SuppressLint("NewApi")
    override fun onBindViewHolder(holder: TovarViewHolder, position: Int) {
        val currentItem = listTovar[position]

        holder.binding.textTitle.text = currentItem.title
        holder.binding.textDescription.text = currentItem.description
        holder.binding.textPrice.text = currentItem.price

        Glide.with(context).load(currentItem.image)
            .thumbnail(Glide.with(context).load(R.drawable.pictures_error))
            .fitCenter()
            .into(holder.binding.imgImage)

        holder.binding.rowCostom.setOnClickListener {
            mIClickListnear.clickListener(position)
        }

    }

    override fun getItemCount(): Int {
        return listTovar.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: ArrayList<TestModels>) {
        listTovar = list
        notifyDataSetChanged()
    }

}
