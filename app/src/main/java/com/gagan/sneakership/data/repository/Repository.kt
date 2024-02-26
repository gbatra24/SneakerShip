package com.gagan.sneakership.data.repository

import com.gagan.sneakership.data.local.CartItemEntity
import com.gagan.sneakership.data.models.Product
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getProducts(): List<Product>

    fun getProductById(id: Int): Product?

    fun getCartItems(): List<CartItemEntity>

    suspend fun getCartCount(): Int

    suspend fun insertCartItem(cartItem: CartItemEntity)

    suspend fun deleteCartItem(cartItem: CartItemEntity)
}