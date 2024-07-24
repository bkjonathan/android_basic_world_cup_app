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
        var countryList = ArrayList<CountryModel>()
        var country1: CountryModel = CountryModel("Brazil","5",R.drawable.brazil)
        var country2: CountryModel = CountryModel("Germany","4",R.drawable.germany)
        var country3: CountryModel = CountryModel("France","2",R.drawable.france)
        var country4: CountryModel = CountryModel("Spain","1",R.drawable.spain)
        var country5: CountryModel = CountryModel("England","1",R.drawable.uk)
        var country6: CountryModel = CountryModel("US","0",R.drawable.us)
        var country7: CountryModel = CountryModel("Qatar","0",R.drawable.qatar)
        countryList.add(country1)
        countryList.add(country2)
        countryList.add(country3)
        countryList.add(country4)
        countryList.add(country5)
        countryList.add(country6)
        countryList.add(country7)
        return countryList
    }
}