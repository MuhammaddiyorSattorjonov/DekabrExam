package com.example.dekabrexam

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import com.example.dekabrexam.databinding.FragmentBlankBinding


class BlankFragment : Fragment() {
    lateinit var binding: FragmentBlankBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlankBinding.inflate(layoutInflater)
        bundleOf().putSerializable("number",binding.raqam.text.toString())
        binding.btn1.setOnClickListener {
            val a = binding.ism.text.toString()
            val b = binding.raqam.text.toString()
            if (a.isNotEmpty() && b.isNotEmpty()) {

                if (MySharedPreferences.catchList.contains(
                        Data(binding.ism.text.toString(), binding.raqam.text.toString())
                    )
                ) {
                    Toast.makeText(context, "Ma'lumotingiz oldin kiritilgan", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    val list = MySharedPreferences.catchList

                    list.add(Data(binding.ism.text.toString(), binding.raqam.text.toString()))
                    MySharedPreferences.catchList = list
                    loadData()
                    binding.ism.text.clear()
                    binding.raqam.text.clear()
                    Toast.makeText(context, "Saqlandi", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(context, "Ma'lumotlarni to'ldiring", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }
    fun loadData() {
        var str = ""
        val list = MySharedPreferences.catchList
        list.forEach {
            str += "${it.name},${it.number}\n\n"
        }
    }
}