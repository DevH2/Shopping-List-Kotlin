package com.example.displayapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    companion object{
        const val KEY_PRODUCT = "product"
    }

    lateinit var searchBar:EditText
    lateinit var buttonConfirm:Button;lateinit var buttonAddProduct:Button
    lateinit var products:ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchBar = findViewById(R.id.searchBar)
        buttonConfirm = findViewById(R.id.buttonConfirm)
        buttonAddProduct = findViewById(R.id.buttonAddProduct)
        products = arrayListOf()

        buttonAddProduct.setOnClickListener {
            if(searchBar.text.toString().isNotEmpty()) {
                products.add(searchBar.text.toString())
                searchBar.text.clear()
            } else {
                searchBar.error = "Please enter a product."
            }
        }
        buttonConfirm.setOnClickListener {
            val intent:Intent = Intent(applicationContext,ProductActivity::class.java)

            intent.putExtra(KEY_PRODUCT, products)
            startActivity(intent)

        }


    }




}