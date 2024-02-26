package com.gagan.sneakership.ui.listings

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.gagan.sneakership.R
import com.gagan.sneakership.data.models.Product
import com.gagan.sneakership.databinding.ActivityProductListingsBinding
import com.gagan.sneakership.ui.cart.CartActivity
import com.gagan.sneakership.ui.details.ProductDetailsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductListingsBinding
    private lateinit var viewModel: ProductListingsVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductListingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[ProductListingsVM::class.java]

        setupUI()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_items, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.ic_cart -> {
                startActivity(Intent(this@ProductListingsActivity, CartActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupUI() {
        setSupportActionBar(binding.myToolbar)
        viewModel.getProducts()
        viewModel.productsList.observe(this) {
            setupProductListingsUI(ArrayList(it))
        }
        setupSearchView()
    }

    private fun setupSearchView() {
//        binding.searchView.
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                if (p0?.length!! > 0) {
                    viewModel.performSearch(p0)
                } else {
                    viewModel.getProducts()
                }
                return false
            }

        })
    }

    private fun setupProductListingsUI(products: ArrayList<Product>) {
        val adapter = ListingsAdapter(products) {
            item -> onListItemClick(item)
        }
        binding.rvProducts.layoutManager = GridLayoutManager(this, 2)
        binding.rvProducts.adapter = adapter
    }

    private fun onListItemClick(item:Product){
        val intent = Intent(this, ProductDetailsActivity::class.java)
        intent.putExtra("id", item.id)
        startActivity(intent)
    }
}