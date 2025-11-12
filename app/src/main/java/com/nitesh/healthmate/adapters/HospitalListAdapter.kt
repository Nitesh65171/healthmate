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
import com.nitesh.healthmate.model.Hospital

class HospitalListAdapter(val context: Context?, val hospitals: ArrayList<Hospital>, val clickListner: HospitalSelectClickListner? = null): RecyclerView.Adapter<HospitalListAdapter.HospitalsViewHolder>() {

    var hospitalList = arrayListOf<Hospital>()

    init {
        hospitalList = hospitals
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateOrderList(orders: ArrayList<Hospital>){
        hospitalList.clear()
        hospitalList.addAll(orders)
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.hospital_item_cell, parent, false)
        return HospitalsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hospitalList.size
    }

    override fun onBindViewHolder(holder: HospitalsViewHolder, position: Int) {
        val hospital = hospitalList.get(position)
        holder.hospitalId.text = hospital.hospitalId
        holder.hospitalName.text = hospital.hospitalName
        holder.hospitalAddress.text = hospital.address
        holder.contactNumber.text = hospital.contact



        holder.itemView.setOnClickListener {
            clickListner?.onHospitalSelect(hospital)
        }
    }

    class HospitalsViewHolder(itemView: View): ViewHolder(itemView){
        val hospitalId = itemView.findViewById<TextView>(R.id.hospital_id)
        val hospitalName = itemView.findViewById<TextView>(R.id.hospital_name)
        val hospitalAddress = itemView.findViewById<TextView>(R.id.hospital_address_value)
        val contactNumber = itemView.findViewById<TextView>(R.id.contact_number)


    }

    interface HospitalSelectClickListner{
        fun onHospitalSelect(hospital: Hospital)
    }

}