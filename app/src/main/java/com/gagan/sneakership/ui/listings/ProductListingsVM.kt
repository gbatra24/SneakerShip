package com.gagan.sneakership.ui.listings

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gagan.sneakership.data.models.Product
import com.gagan.sneakership.data.repository.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import javax.inject.Inject
import kotlin.system.exitProcess

@HiltViewModel
class ProductListingsVM @Inject constructor(
    private val repository: ProductsRepository
): ViewModel(){

    val productsList = MutableLiveData<List<Product>>()

    fun getProducts() = viewModelScope.launch(Dispatchers.IO) {
        val prods = repository.getProducts()
        withContext(Dispatchers.Main) {
            productsList.value = prods
        }
    }

    fun performSearch(query: String) = viewModelScope.launch(Dispatchers.IO) {
        val prods = repository.getProducts().filter {
            product -> product.title.contains(query, true) }

        withContext(Dispatchers.Main) {
            productsList.value = prods
        }
    }

}