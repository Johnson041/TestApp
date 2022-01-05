package com.example.testapp

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

class TestLifeCycle(val lifeCycle: Lifecycle): DefaultLifecycleObserver {

    override fun onCreate(owner: LifecycleOwner) {
        Log.d("life oncreate test", owner.toString() )
        super.onCreate(owner)
    }

    override fun onDestroy(owner: LifecycleOwner) {
        Log.d("life onDestroy", owner.toString())
        super.onDestroy(owner)
    }


}

