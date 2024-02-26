package com.gagan.sneakership.data.mappers

import com.gagan.sneakership.data.local.CartItemEntity
import com.gagan.sneakership.data.models.Product
import javax.inject.Inject

class ProductCartMapper @Inject constructor() : Mapper<Product, CartItemEntity> {
    override fun mapProductToCartItem(product: Product): CartItemEntity {
        return CartItemEntity(
            id  = product.id,
            title = product.title,
            retailPrice = product.retailPrice,
            url = product.media.imageUrl
        )
    }

    override fun mapCartItemToProduct(cartItem: CartItemEntity): Product {
        TODO("Not yet implemented")
    }

}