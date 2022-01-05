package com.example.testapp

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecylerAdaptor(val context: Context, private val dataSet: ArrayList<String>): RecyclerView.Adapter<RecylerAdaptor.RecylerViewHolder>() {



    inner class RecylerViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        val tx1: TextView = view.findViewById(R.id.rtx1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecylerViewHolder {
        Log.d("parent", parent.toString())
        Log.d("viewType", viewType.toString())

        val adaptor = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
//       Toast.makeText(context, adaptor.toString(), Toast.LENGTH_SHORT).show()
        return RecylerViewHolder(adaptor)
    }

    override fun onBindViewHolder(holder: RecylerViewHolder, position: Int) {
        Log.d("onBind", holder.toString())
        val item = dataSet[position]
        holder.tx1.text = item
    }

    override fun getItemCount(): Int {
        Log.d("getCout", dataSet.size.toString())
        return dataSet.size
    }
}