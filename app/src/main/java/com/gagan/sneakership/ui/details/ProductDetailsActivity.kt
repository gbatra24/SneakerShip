package com.gagan.sneakership.ui.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.gagan.sneakership.data.models.Product
import com.gagan.sneakership.databinding.ActivityProductDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailsBinding
    private lateinit var viewModel: ProductDetailsVM
    private var productId:Int = -1
    private lateinit var product: Product

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[ProductDetailsVM::class.java]

        getDataFromIntent()
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

    private fun getDataFromIntent() {
        productId = intent.getIntExtra("id", -1)
        product = viewModel.getProductById(productId)!!
    }

    private fun setupUI() {
        setupToolbar()
        setupProductDetailsSection()
        setupAddToCartBtn()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.myToolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

    }

    private fun setupProductDetailsSection() {
        Glide
            .with(binding.ivThumbnail)
            .load(product.media.imageUrl)
            .centerCrop()
            .into(binding.ivThumbnail)

        binding.tvName.text = product.title
        val price = "Price: ${product.retailPrice}"
        binding.tvPrice.text = price

    }

    private fun setupAddToCartBtn() {
        binding.btnAddToCart.setOnClickListener{
            viewModel.addToCart(product)
            binding.btnAddToCart.visibility = View.GONE

            Toast.makeText(this@ProductDetailsActivity,
                "Product added in cart", Toast.LENGTH_LONG).show()
        }
    }


}