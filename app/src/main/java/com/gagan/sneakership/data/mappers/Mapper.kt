package com.gagan.sneakership.data.mappers

interface Mapper<First, Second> {
    fun mapProductToCartItem(response: First): Second

    fun mapCartItemToProduct(model: Second): First
}