package com.task.baseadaptertask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
class ListAdapter(var list:ArrayList<String>):BaseAdapter(){
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return 1L
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.activity_list_adapter,parent,false)
        val textView=view.findViewById<TextView>(R.id.textView)
        textView.setText(list[position])
        return view
    }

}