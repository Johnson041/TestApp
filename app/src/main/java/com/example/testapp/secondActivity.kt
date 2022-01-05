package com.example.testapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class secondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val viewPager: ViewPager2 = findViewById(R.id.viewpager1)
        val tablayout: TabLayout = findViewById(R.id.tablayout1);
        val isair  = Settings.System.getInt(applicationContext.contentResolver, Settings.System.AIRPLANE_MODE_ON)
        val tabTitle =  arrayOf("t1", "t2", "t3")
//        viewPager.adapter = PagerAdaptor(supportFragmentManager)
//        tablayout.setupWithViewPager(viewPager)




        viewPager.adapter = PagerAdaptor(supportFragmentManager, lifecycle)
        TabLayoutMediator(tablayout, viewPager){
                tab, position ->
                    tab.text = tabTitle[position]


        }.attach()

        val message =  intent.getStringExtra("com.john")
        val textView = findViewById<TextView>(R.id.t2).apply {
            text = message
        }
        val b1: Button = findViewById(R.id.b1)
        b1.setOnClickListener {

            //open gmail
//            val intent = Intent(Intent.ACTION_SEND)
//            intent.type ="text/plain"
//            intent.putExtra(Intent.EXTRA_EMAIL, "HELLO@gmail.com")
//            startActivity(intent)

            //open video player
//            val intent = Intent(Intent.ACTION_VIEW)
//            intent.setDataAndType(Uri.parse("https://www.youtube.com/watch?v=ivA0jRWgf5Q&t=3833s"), "video/mp4")
//            startActivity(intent)

            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 9942))
            startActivity(intent)



        }
    }


}