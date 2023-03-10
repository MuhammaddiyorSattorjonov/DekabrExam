package com.example.dekabrexam

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.dekabrexam.databinding.ItemRvBinding

class ListAdapter(context:Context,val list: ArrayList<Data>): ArrayAdapter<Data>(context,
    R.layout.item_rv,list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var myItemBinding = ItemRvBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        myItemBinding.name.text = list[position].name
        myItemBinding.number.text = list[position].number

        return myItemBinding.root
    }

}