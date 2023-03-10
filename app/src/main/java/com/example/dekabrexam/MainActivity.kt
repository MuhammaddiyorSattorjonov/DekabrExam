package com.example.dekabrexam

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.dekabrexam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var adapter: ViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        MySharedPreferences.init(this)

        val blank1 = BlankFragment()
        val blank2 = BlankFragment2()
        binding.myTab.setupWithViewPager(binding.viewPager2)


        adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(blank1,"Add")
        adapter.addFragment(blank2,"List users")
        binding.viewPager2.adapter = adapter

        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.CALL_PHONE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this, arrayOf(android.Manifest.permission.CALL_PHONE),
                200
            )

        } else {

        }

    }
}