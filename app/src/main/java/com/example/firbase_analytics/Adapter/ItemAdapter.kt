package com.example.firbase_analytics.Adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firbase_analytics.DetailsActivity
import com.example.firbase_analytics.R
import com.example.firbase_analytics.Models.item
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.card_item.view.*


class ItemAdapter(var activity: Activity, var data:MutableList<item>): RecyclerView.Adapter<ItemAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imag = itemView.imag
        val item = itemView
        val name = itemView.txt_name

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(activity).inflate(R.layout.card_item, parent, false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Picasso.get()
            .load(data[position].image)
            .into(holder.imag)
        holder.name.text  = data[position].name
        holder.item.setOnClickListener {
           var intent = Intent(activity,DetailsActivity::class.java)
            intent.putExtra("obj",data[position])
            activity.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}