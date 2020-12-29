package com.example.displayapp

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class ProductActivity : AppCompatActivity() {
    lateinit var listView:ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_layout)

        listView = findViewById(R.id.listView)
        var products:ArrayList<String> = intent.getStringArrayListExtra(MainActivity.KEY_PRODUCT) as ArrayList<String>

        listView.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,products)

        listView.setOnItemClickListener { adapterView, view, i, l ->
            products.remove(products[i])
            (listView.adapter as ArrayAdapter<String>).notifyDataSetChanged()
        }
    }
}