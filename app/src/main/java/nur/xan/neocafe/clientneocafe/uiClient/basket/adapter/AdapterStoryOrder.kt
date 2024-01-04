package nur.xan.neocafe.clientneocafe.uiClient.basket.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import nur.xan.neocafe.clientneocafe.R
import nur.xan.neocafe.clientneocafe.databinding.ItemAllBinding
import nur.xan.neocafe.clientneocafe.databinding.ItemBasketBinding
import nur.xan.neocafe.clientneocafe.interfaces.IClickListnearOnBasket
import nur.xan.neocafe.clientneocafe.interfaces.IClickListnearOnClick
import nur.xan.neocafe.clientneocafe.models.test.TestModels
import kotlin.collections.ArrayList

class AdapterBasket(private val mIClickListnear: IClickListnearOnBasket) :

    RecyclerView.Adapter<AdapterBasket.TovarViewHolder>() {
    lateinit var context: Context

    var listTovar = ArrayList<TestModels>()

    class TovarViewHolder(val binding: ItemBasketBinding) : RecyclerView.ViewHolder(binding.root)

    @SuppressLint("NotifyDataSetChanged")
    fun deleteMyEducations(position: Int) {
        listTovar.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, listTovar.size)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TovarViewHolder {
        val binding = ItemBasketBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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
            .into(holder.binding.imgImage)

        holder.binding.rowCostom.setOnClickListener {
            mIClickListnear.clickListener(position)
        }

        holder.binding.menuMinus.setOnClickListener {
            mIClickListnear.clickListenerMenuDelete(position)
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
