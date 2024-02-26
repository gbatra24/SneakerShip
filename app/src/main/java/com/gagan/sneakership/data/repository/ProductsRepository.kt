package com.gagan.sneakership.data.repository

import com.gagan.sneakership.data.local.AppDao
import com.gagan.sneakership.data.local.CartItemEntity
import com.gagan.sneakership.data.models.Product
import com.gagan.sneakership.data.remote.RemoteData
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ActivityRetainedScoped
class ProductsRepository @Inject constructor(
    private val remoteData: RemoteData,
    private val appDao: AppDao
): Repository {

    override fun getProducts(): List<Product> = remoteData.getAllProducts()

    override fun getProductById(id: Int): Product? = remoteData.getProductById(id)

    override fun getCartItems(): List<CartItemEntity> = appDao.getCartItems()

    override suspend fun getCartCount(): Int = appDao.getCartCount()

    override suspend fun insertCartItem(cartItem: CartItemEntity) = appDao.insertCartItem(cartItem)

    override suspend fun deleteCartItem(cartItem: CartItemEntity) = appDao.deleteCartItem(cartItem)
}