package com.thomasstudiomdy.worldcupapp

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Adapter View
        val listView = findViewById<ListView>(R.id.listView)

        // Adapter

        val adapter = MyAdapter(this,generateData())
        listView?.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    // Data Source
    fun generateData():ArrayList<CountryModel>{
        val countryList = ArrayList<CountryModel>()
        countryList.add(CountryModel("Brazil","5",R.drawable.brazil))
        countryList.add(CountryModel("Germany","4",R.drawable.germany))
        countryList.add(CountryModel("France","2",R.drawable.france))
        countryList.add(CountryModel("Spain","1",R.drawable.spain))
        countryList.add(CountryModel("England","1",R.drawable.uk))
        countryList.add(CountryModel("US","0",R.drawable.us))
        countryList.add(CountryModel("Qatar","0",R.drawable.qatar))
        return countryList
    }
}