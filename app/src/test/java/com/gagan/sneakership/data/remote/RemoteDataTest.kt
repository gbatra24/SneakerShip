package com.gagan.sneakership.data.remote

import com.gagan.sneakership.data.models.Media
import com.gagan.sneakership.data.models.Product
import org.junit.Assert.*

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class RemoteDataTest {

    private lateinit var products: List<Product>
    @Before
    fun setUp() {
        products = listOf(
            Product(
                id = 0,
                brand = "Nike",
                colorway = "",
                gender = "",
                media = Media(imageUrl = "https://images.unsplash.com/photo-1580906853149-f82f7601d205?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1974&q=80",),
                releaseDate = "2022-12-15",
                retailPrice = 4999,
                styleId = "",
                shoe = "",
                name = "Air Jordan 1",
                title = "Nike Air Jordan 1",
                year = 0
            ),
            Product(
                id = 1,
                brand = "Nike",
                colorway = "",
                gender = "",
                media = Media(imageUrl = "https://images.unsplash.com/photo-1514989940723-e8e51635b782?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80",),
                releaseDate = "2022-12-15",
                retailPrice = 5999,
                styleId = "",
                shoe = "",
                name = "Air Jordan 2",
                title = "Nike Air Jordan 2",
                year = 0
            ),
            Product(
                id = 2,
                brand = "Nike",
                colorway = "",
                gender = "",
                media = Media(imageUrl = "https://images.unsplash.com/photo-1600181516264-3ea807ff44b9?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=987&q=80",),
                releaseDate = "2022-12-15",
                retailPrice = 5499,
                styleId = "",
                shoe = "",
                name = "Air Jordan 3",
                title = "Nike Air Jordan 3",
                year = 0
            ),
            Product(
                id = 3,
                brand = "Nike",
                colorway = "",
                gender = "",
                media = Media(imageUrl = "https://images.unsplash.com/photo-1600185365483-26d7a4cc7519?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1625&q=80",),
                releaseDate = "2022-12-15",
                retailPrice = 6499,
                styleId = "",
                shoe = "",
                name = "Air Jordan 4",
                title = "Nike Air Jordan 4",
                year = 0
            ),
            Product(
                id = 4,
                brand = "Nike",
                colorway = "",
                gender = "",
                media = Media(imageUrl = "https://images.unsplash.com/photo-1600185365483-26d7a4cc7519?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1625&q=80",),
                releaseDate = "2022-12-15",
                retailPrice = 6499,
                styleId = "",
                shoe = "",
                name = "Air Max 1",
                title = "Nike Air Max 1",
                year = 0
            ),
            Product(
                id = 5,
                brand = "Nike",
                colorway = "",
                gender = "",
                media = Media(imageUrl = "https://images.unsplash.com/photo-1600185365483-26d7a4cc7519?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1625&q=80",),
                releaseDate = "2022-12-15",
                retailPrice = 6499,
                styleId = "",
                shoe = "",
                name = "Air Max 2",
                title = "Nike Air Max 2",
                year = 0
            ),
            Product(
                id = 6,
                brand = "Nike",
                colorway = "",
                gender = "",
                media = Media(imageUrl = "https://images.unsplash.com/photo-1600185365483-26d7a4cc7519?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1625&q=80",),
                releaseDate = "2022-12-15",
                retailPrice = 6499,
                styleId = "",
                shoe = "",
                name = "Air Max 3",
                title = "Nike Air Max 3",
                year = 0
            ),
            Product(
                id = 7,
                brand = "Nike",
                colorway = "",
                gender = "",
                media = Media(imageUrl = "https://images.unsplash.com/photo-1600185365483-26d7a4cc7519?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1625&q=80",),
                releaseDate = "2022-12-15",
                retailPrice = 6499,
                styleId = "",
                shoe = "",
                name = "Air Max 4",
                title = "Nike Air Max 4",
                year = 0
            ),
        )
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getAllProducts_checkLength() {
        assertEquals(8, products.size)
    }

    @Test
    fun getProductById() {
        val productId = 0
        val product = products.find { product -> product.id == productId }

        assertEquals(0, product?.id)
    }
}