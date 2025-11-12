package com.faishion.vaama.orders.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.nitesh.healthmate.R
import com.nitesh.healthmate.model.HomeRemedy

class HomeListRemediesListAdapter(val context: Context?, val remedies: ArrayList<HomeRemedy>, val clickListner: HomeRemediesClickListner? = null): RecyclerView.Adapter<HomeListRemediesListAdapter.HomeRemediesViewHolder>() {

    var remediesList = arrayListOf<HomeRemedy>()

    init {
        remediesList = remedies
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateOrderList(remedies: ArrayList<HomeRemedy>){
        remediesList.clear()
        remediesList.addAll(remedies)
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRemediesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.remedies_item_cell, parent, false)
        return HomeRemediesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return remediesList.size
    }

    override fun onBindViewHolder(holder: HomeRemediesViewHolder, position: Int) {
        val remedie = remediesList.get(position)
        holder.remediesTitle.text = remedie.title
        holder.category.text = remedie.category
        holder.shortDescription.text = remedie.shortDescription



        holder.itemView.setOnClickListener {
            clickListner?.onRemediesCLick(remedie)
        }
    }

    class HomeRemediesViewHolder(itemView: View): ViewHolder(itemView){
        val remediesTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        val category = itemView.findViewById<TextView>(R.id.tvCategory)
        val shortDescription = itemView.findViewById<TextView>(R.id.tvShortDesc)


    }

    interface HomeRemediesClickListner{
        fun onRemediesCLick(remedy: HomeRemedy)
    }

}