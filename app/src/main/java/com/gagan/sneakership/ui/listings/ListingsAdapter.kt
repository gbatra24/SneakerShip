package com.gagan.sneakership.ui.listings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gagan.sneakership.data.models.Product
import com.gagan.sneakership.databinding.RvItemProductBinding

class ListingsAdapter(private val products: ArrayList<Product>,
                      private val onItemClick: (Product) -> Unit
) : RecyclerView.Adapter<ListingsAdapter.ListingsViewHolder>() {

    inner class ListingsViewHolder(private val binding: RvItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(product: Product) {
            binding.tvName.text = product.title
            val price = "INR ${product.retailPrice}"
            binding.tvPrice.text = price

            Glide
                .with(binding.ivThumbnail)
                .load(product.media.imageUrl)
                .centerCrop()
                .into(binding.ivThumbnail)

            binding.cvRoot.setOnClickListener {
                onItemClick(product)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListingsViewHolder {
        val binding = RvItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListingsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return products.size;
    }

    override fun onBindViewHolder(holder: ListingsViewHolder, position: Int) {
        holder.onBind(products[position])
    }
}