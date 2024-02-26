package com.gagan.sneakership.ui.cart

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gagan.sneakership.data.local.CartItemEntity
import com.gagan.sneakership.data.mappers.ProductCartMapper
import com.gagan.sneakership.data.models.Product
import com.gagan.sneakership.data.repository.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CartVM @Inject constructor(
    private val repository: ProductsRepository
): ViewModel() {

    init {
        getCartItems()
    }

    val cartItems = MutableLiveData<List<CartItemEntity>>()
    val cartValue = MutableLiveData<Int>()

    private fun getCartItems() = viewModelScope.launch(Dispatchers.IO) {
        val items = repository.getCartItems()
        withContext(Dispatchers.Main) {
            cartItems.value = items
            var total = 0
            for (i in items) {
                total += i.retailPrice
            }
            cartValue.value = total
        }
    }

    fun removeFromCart(cartItem: CartItemEntity) = viewModelScope.launch(Dispatchers.IO + NonCancellable){
        repository.deleteCartItem(cartItem)
        getCartItems()
    }

}