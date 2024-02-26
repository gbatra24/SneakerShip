package com.gagan.sneakership.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gagan.sneakership.data.mappers.ProductCartMapper
import com.gagan.sneakership.data.models.Product
import com.gagan.sneakership.data.repository.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailsVM @Inject constructor(
    private val repository: ProductsRepository,
    private val mapper: ProductCartMapper
) : ViewModel() {

    fun getProductById(id: Int) = repository.getProductById(id)

    fun addToCart(product: Product) = viewModelScope.launch(Dispatchers.IO + NonCancellable){
        repository.insertCartItem(mapper.mapProductToCartItem(product))
    }

}