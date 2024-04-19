package com.example.listview2

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

class MyAdapter(val context :Activity , val arrayList: ArrayList<User>) : ArrayAdapter<User>(context, R.layout.eachitem,arrayList)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return super.getView(position, convertView, parent)
    }
}