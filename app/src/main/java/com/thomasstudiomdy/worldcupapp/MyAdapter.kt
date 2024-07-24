package com.thomasstudiomdy.worldcupapp

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MyAdapter(private var activity:Activity, private var items:ArrayList<CountryModel>) : BaseAdapter() {
    override fun getCount(): Int {
        return  items.size
    }

    override fun getItem(p0: Int): CountryModel {
        return items[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, convertedView: View?, p2: ViewGroup?): View {
        val view:View?
        val viewHolder:ViewHolder
        if (convertedView == null){
            val inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.list_item_layout,null)
            viewHolder = ViewHolder(view)
            view?.tag  = viewHolder
        }else{
            view = convertedView
            viewHolder = view.tag as ViewHolder
        }

        val countries = items[position]
        viewHolder.txtName?.text = countries.name
        viewHolder.txtCupWin?.text = countries.cupWins
        viewHolder.flagImg?.setImageResource(countries.flagImg)

        view?.setOnClickListener(){
            Toast.makeText(activity,"You Choose: ${countries.name}",Toast.LENGTH_SHORT).show()
        }
        return view as View

    }

    private class ViewHolder(row:View?){
        var txtName:TextView? =null
        var txtCupWin:TextView? = null
        var flagImg:ImageView? = null

        init {
            this.txtName = row?.findViewById(R.id.countryName)
            this.txtCupWin = row?.findViewById(R.id.totalWin)
            this.flagImg = row?.findViewById(R.id.imageView)
        }
    }

}