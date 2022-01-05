package com.example.testapp

import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.content.pm.ShortcutManagerCompat
import androidx.core.graphics.drawable.IconCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {

    lateinit var receiver: BroadClass
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        super.onCreate(savedInstanceState)
        lifecycle.addObserver(TestLifeCycle(lifecycle))
        Log.d("life oncreate", savedInstanceState.toString())
        setContentView(R.layout.activity_main)
        val b1 = findViewById<Button>(R.id.f1bt)
        val b2 = findViewById<Button>(R.id.f2bt)

        b1.setOnClickListener {
            replaceFragment(Fragment1())
        }
        b2.setOnClickListener {
            replaceFragment(Fragment2())
        }


        receiver = BroadClass()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver, it)
        }
        val shortcut = ShortcutInfoCompat.Builder(this, "Vin")
            .setShortLabel("John")
            .setLongLabel("hello John")
            .setIcon(IconCompat.createWithResource(this, R.drawable.ic_launcher_background))
            .setIntent(Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com/guide/topics/ui/shortcuts/managing-shortcuts")))
            .build()
        ShortcutManagerCompat.pushDynamicShortcut(this, shortcut)
    }

    fun sendMessage(view: View) {
        Log.d("view", view.toString())
        val editText = findViewById<EditText>(R.id.e1)
        val message = editText.text.toString()
        val intent = Intent(this, secondActivity::class.java).apply {
            putExtra("com.john", message)
        }
        startActivity(intent)
    }


    private fun replaceFragment(fragement: Fragment){
        supportFragmentManager.commit {
            replace(R.id.fcontainer, fragement)
//            setReorderingAllowed(true)
//            addToBackStack("john")
        }


    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        outState?.run {
//            putString("GAME_STATE_KEY", "gameState")
//            putString("TEXT_VIEW_KEY", "textView")
//        }
//        Log.d("john onsaveinst", outState.toString())
//
//        super.onSaveInstanceState(outState)
//    }
//
//     override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//         Log.d("john onRestoreIn", savedInstanceState.toString())
//        super.onRestoreInstanceState(savedInstanceState)
//    }

    override fun onPause() {
    Log.d("pause", "paused")
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }


}