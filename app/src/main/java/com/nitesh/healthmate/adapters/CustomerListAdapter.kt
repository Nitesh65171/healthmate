package com.faishion.vaama.orders.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.nitesh.healthmate.R
import com.nitesh.healthmate.model.Customer
import com.nitesh.healthmate.model.Hospital

class CustomerListAdapter(val context: Context?, val customers: ArrayList<Customer>, val clickListner: CustomerListSelectClickListner? = null): RecyclerView.Adapter<CustomerListAdapter.CustomersViewHolder>() {

    var customerList = arrayListOf<Customer>()

    init {
        customerList = customers
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateOrderList(updateCusotmerList: ArrayList<Customer>){
        customerList.clear()
        customerList.addAll(updateCusotmerList)
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomersViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.customer_item_cell, parent, false)
        return CustomersViewHolder(view)
    }

    override fun getItemCount(): Int {
        return customerList.size
    }

    @SuppressLint("SetTextI18n", "ResourceAsColor")
    override fun onBindViewHolder(holder: CustomersViewHolder, position: Int) {
        val customer = customerList.get(position)
        holder.customerName.text = "${customer.name}"
        holder.customerAge.text = "${customer.age} years"
        holder.customerDiagnosis.text = customer.diagnosis
        holder.customerAddress.text = customer.address
        holder.contactNumber.text = customer.phone
        holder. customerImage.setImageResource(R.drawable.customer_placeholder)
        val color = if (context != null) {
            when(customer.diagnosisSeverityCode){
                1 -> context.resources.getColor(R.color.green)
                2 -> context.resources.getColor(R.color.yellow)
                3 -> context.resources.getColor(R.color.red)
                else -> context.resources.getColor(R.color.green)
            }
        }else {
            R.color.green
        }
        holder.severityParentLayout.setBackgroundColor(color)

        holder.itemView.setOnClickListener {
            clickListner?.onCustomerSelect(customer)
        }
    }

    class CustomersViewHolder(itemView: View): ViewHolder(itemView){
        val customerName = itemView.findViewById<TextView>(R.id.customer_name)
        val customerAge = itemView.findViewById<TextView>(R.id.customer_age)
        val customerDiagnosis = itemView.findViewById<TextView>(R.id.dignoaissue_name)
        val customerAddress = itemView.findViewById<TextView>(R.id.customer_address_value)
        val contactNumber = itemView.findViewById<TextView>(R.id.contact_number)
        val customerImage = itemView.findViewById<ImageView>(R.id.product_order_iv)
        val customerParentLayout = itemView.findViewById<LinearLayout>(R.id.customer_parent_ll)
        val severityParentLayout = itemView.findViewById<LinearLayout>(R.id.severity_indicator_ll)
    }

    interface CustomerListSelectClickListner{
        fun onCustomerSelect(customer: Customer)
    }

}