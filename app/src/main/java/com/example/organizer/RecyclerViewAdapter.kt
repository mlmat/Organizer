package com.example.organizer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter (val dataList: ArrayList<DataModel>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0?.context).inflate(R.layout.adapter_item_layout, p0, false)
        return ViewHolder(v);
    }
    override fun getItemCount(): Int {
        return dataList.size
    }
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

        p0.title?.text = dataList[p1].title
        p0.id?.text = dataList[p1].id.toString()
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.tvName)
        val id = itemView.findViewById<TextView>(R.id.tvCount)

    }
}