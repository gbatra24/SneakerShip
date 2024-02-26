package com.gagan.sneakership.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gagan.sneakership.data.local.CartItemEntity
import com.gagan.sneakership.databinding.RvItemCartBinding

class CartAdapter(private val products: ArrayList<CartItemEntity>,
                  private val onItemClick: (CartItemEntity) -> Unit
): RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    inner class CartViewHolder(private val binding: RvItemCartBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: CartItemEntity) {
            Glide
                .with(binding.ivThumbnail)
                .load(item.url)
                .centerCrop()
                .into(binding.ivThumbnail)

            binding.tvName.text = item.title
            binding.tvPrice.text = item.retailPrice.toString()

            binding.btnRemove.setOnClickListener{
                onItemClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = RvItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.onBind(products[position])
    }
}