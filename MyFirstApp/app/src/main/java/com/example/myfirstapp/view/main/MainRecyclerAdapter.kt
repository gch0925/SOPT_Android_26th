package com.example.myfirstapp.view.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myfirstapp.data.AData
import com.example.myfirstapp.R

class MainRecyclerAdapter : RecyclerView.Adapter<MainRecyclerAdapter.Vholder>() {

    var datas = mutableListOf<AData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mainrecyclerview,parent,false)
        return Vholder(view)
    }

    override fun onBindViewHolder(holder: Vholder, position: Int) {
        holder.setHolder(datas[position])
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    class Vholder(itemview : View) : RecyclerView.ViewHolder(itemview){

        val tv_top = itemview.findViewById<TextView>(R.id.text_top)
        val img_top = itemview.findViewById<ImageView>(R.id.image_top)
        val img_main = itemview.findViewById<ImageView>(R.id.image_main)

        fun setHolder(item : AData){
            tv_top.text = item.text_top
            Glide.with(itemView).load(item.img_top).into(img_top)
            Glide.with(itemView).load(item.img_main).into(img_main)
        }

    }
}