package com.nitesh.healthmate.hospitalsection.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nitesh.healthmate.R
import com.nitesh.healthmate.hospitalsection.model.AlertRequest
import com.nitesh.healthmate.model.Customer
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class RequestListAdapter(val context: Context?, val requests: ArrayList<AlertRequest>, val clickListner: RequestListSelectClickListner? = null) : RecyclerView.Adapter<RequestListAdapter.AlertRequestViewHolder>() {

    var requestList = arrayListOf<AlertRequest>()

    init {
        requestList = requests
    }

    class AlertRequestViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){


        val patientName = itemView.findViewById<TextView>(R.id.tvName)

        val severityLabel = itemView.findViewById<TextView>(R.id.tvSeverity)

        val diagnosis = itemView.findViewById<TextView>(R.id.tvDiagnosis)

        val emergencyType = itemView.findViewById<TextView>(R.id.tvEmergencyType)

        val address = itemView.findViewById<TextView>(R.id.tvAddress)

        val age = itemView.findViewById<TextView>(R.id.tvAge)

        val time = itemView.findViewById<TextView>(R.id.tvTime)

        val severityContainer = itemView.findViewById<View>(R.id.tvSeverity)
        // used for color change / animation
    }

    interface RequestListSelectClickListner{
        fun onRequestSelected(alert: AlertRequest)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlertRequestViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_alert_request, parent, false)
        return AlertRequestViewHolder(view)
    }

    override fun getItemCount(): Int {
       return requestList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: AlertRequestViewHolder, position: Int) {
        val item = requestList.get(position)

        holder.patientName.text = item.patientName
        holder.diagnosis.text = item.diagnosis
        holder.emergencyType.text = item.emergencyType
        holder.address.text = item.address
        holder.time.text = SimpleDateFormat("hh:mm a", Locale.getDefault())
            .format(Date(item.createdAt))
        holder.age.text = "${item.age} years"

       when(item.severityLevel){
            3 -> {
                holder.severityLabel.text = "EMERGENCY"
                holder.severityLabel.setBackgroundColor(context!!.getColor(R.color.red))
            }
            2 -> {
                holder.severityLabel.text = "URGENT"
                holder.severityLabel.setBackgroundColor(context!!.getColor(R.color.yellow))
            }
            else -> {
                holder.severityLabel.text = "NORMAL"
                holder.severityLabel.setBackgroundColor(context!!.getColor(R.color.green))
            }
        }

        holder.itemView.setOnClickListener {
            clickListner?.onRequestSelected(item)
        }
    }
}