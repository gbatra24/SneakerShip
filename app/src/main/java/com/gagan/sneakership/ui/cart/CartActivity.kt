package com.gagan.sneakership.ui.cart

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.gagan.sneakership.data.local.CartItemEntity
import com.gagan.sneakership.databinding.ActivityCartBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCartBinding
    private lateinit var viewModel: CartVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[CartVM::class.java]

        setupUI()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupUI() {
        setupToolbar()
        setupCartRv()
        setupOrderDetailsSection()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.myToolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    private fun setupCartRv() {
        var products: ArrayList<CartItemEntity>
        viewModel.cartItems.observe(this) {
            products = it as ArrayList<CartItemEntity>
            val adapter = CartAdapter(products) {
                    item -> onListItemClick(item)
            }
            binding.rvCart.layoutManager = LinearLayoutManager(this)
            binding.rvCart.adapter = adapter
        }
    }

    private fun onListItemClick(item: CartItemEntity) {
        viewModel.removeFromCart(item)
    }

    private fun setupOrderDetailsSection() {
        viewModel.cartValue.observe(this) {
            val subtotal = "Subtotal: INR $it"
            binding.tvPrice.text = subtotal
        }

        binding.btnCheckout.setOnClickListener{
            Toast.makeText(this, "Thank you for shopping with us !", Toast.LENGTH_LONG).show()
        }
    }
}