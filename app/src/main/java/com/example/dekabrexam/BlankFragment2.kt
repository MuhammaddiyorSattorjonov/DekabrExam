package com.example.dekabrexam

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.dekabrexam.databinding.FragmentBlank2Binding

class BlankFragment2 : Fragment() {
    lateinit var binding: FragmentBlank2Binding
    lateinit var list:ArrayList<Data>
    lateinit var adapter: ListAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlank2Binding.inflate(this.layoutInflater)
        list = MySharedPreferences.catchList
        adapter = context?.let { ListAdapter(it,list) }!!
        binding.recycleView.adapter = adapter

        binding.recycleView.setOnItemClickListener { adapterView, view, position, l ->
       val a = MySharedPreferences.catchList[position].number
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$a"));
            startActivity(intent)
        }
        binding.recycleView.setOnItemLongClickListener{adapterView, view, position, l ->
            val a = MySharedPreferences.catchList[position].number
            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:$a"))
            startActivity(intent)
            return@setOnItemLongClickListener(true)
        }
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        list.clear()
        list.addAll(MySharedPreferences.catchList)
        adapter.notifyDataSetChanged()
    }
}