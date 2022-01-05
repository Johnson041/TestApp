package com.example.testapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BroadClass: BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        var isOn = p1?.getBooleanExtra("state", false) ?: return
        if(isOn)
        {
            Toast.makeText(p0, "On",Toast.LENGTH_LONG).show()
        }
    else
        {
            Toast.makeText(p0, "Off",Toast.LENGTH_LONG).show()

        }
    }
}