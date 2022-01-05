package com.example.testapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter


class PagerAdaptor(fm: FragmentManager, lifeCycle: Lifecycle): FragmentStateAdapter(fm, lifeCycle)
{
    override fun getItemCount(): Int {

        return 3

    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> {
                Fragment1()
            }
            1 -> {
                Fragment2()
            }
            2 -> {
                Tab1()
            }
            else -> {
                Fragment1()
            }

        }
    }

}

//class PagerAdaptor(fm: FragmentManager): FragmentPagerAdapter(fm) {
//    override fun getCount(): Int {
//
//        return 3
//    }
//
//    override fun getItem(position: Int): Fragment {
//        return when(position) {
//            0 -> {
//                Fragment1()
//            }
//            1 -> {
//                Fragment2()
//            }
//            2 -> {
//                Tab1()
//            }
//            else -> {
//                Fragment1()
//            }
//
//        }
//    }
//
//    override fun getPageTitle(position: Int): CharSequence? {
//        return when(position) {
//            0 -> {
//                "Tab1"
//            }
//            1 -> {
//                "Tab2"
//            }
//            2 -> {
//                "Tab3"
//            }
//            else -> {
//                "Tab1"
//            }
//
//        }
//        return super.getPageTitle(position)
//    }
//}