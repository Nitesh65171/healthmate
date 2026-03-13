package com.nitesh.healthmate.hospitalsection.fragment

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.faishion.vaama.orders.adapter.CustomerListAdapter
import com.nitesh.healthmate.R
import com.nitesh.healthmate.activities.HospitalLandingActivity
import com.nitesh.healthmate.databinding.FragmentCustomerListBinding
import com.nitesh.healthmate.model.Customer
import com.nitesh.healthmate.model.DiagnosisSeverity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CustomerListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CustomerListFragment : Fragment(), CustomerListAdapter.CustomerListSelectClickListner {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentCustomerListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCustomerListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity is HospitalLandingActivity){
            (activity as HospitalLandingActivity).title = "Patients"
        }

        val serverityRadioGroup = binding.severityFilterRg
        val customers = customerArrayList()
        val customerListAdapter = CustomerListAdapter(context, customers, this)
        serverityRadioGroup.setOnCheckedChangeListener { radioGroup, i ->
           val filteredCustomer =  when(i){
                R.id.low_severity -> {
                    customerArrayList(DiagnosisSeverity.LOW.code)
                }
                R.id.medium_severity -> {
                    customerArrayList(DiagnosisSeverity.MEDIUM.code)
                }
                R.id.high_severity -> {
                    customerArrayList(DiagnosisSeverity.HIGH.code)
                }
               else ->  customerArrayList()
            }
            customerListAdapter.updateOrderList(filteredCustomer)

        }



        binding.customerRv.adapter = customerListAdapter
        binding.customerRv.layoutManager = LinearLayoutManager(context)
    }

    private fun customerArrayList(serverity: Int? = 0): ArrayList<Customer> {
        val customers = arrayListOf<Customer>(
            Customer(
                "C100",
                "Kamal Sharma",
                "Tranport Nagar, Agra, Uttar Pradesh",
                "Cold",
                "kamal.sharma@example.com",
                "9876543210",
                28,
                1,
                "Condition: Mild Cold\nSymptoms: Sneezing, light congestion\nDoctor Notes: No infection signs\nTreatment: Steam inhalation + rest\nAdvice: Drink warm fluids and avoid cold exposure."
            ),
            Customer(
                "C101",
                "Rohit Sharma",
                "Kamla Nagar, Agra, Uttar Pradesh",
                "Fever",
                "rohit.sharma@example.com",
                "9876543210",
                28,
                2,
                "Condition: Moderate Fever\nTemperature: 101°F recorded\nDoctor Notes: Possible viral infection\nTreatment: Paracetamol course started\nAdvice: Stay hydrated and monitor temperature every 4 hours."
            ),
            Customer(
                "C102",
                "Priya Verma",
                "Dayal Bagh, Agra, Uttar Pradesh",
                "Severe Migraine",
                "priya.verma@example.com",
                "9123456780",
                32,
                2,
                "Condition: Severe Migraine Episode\nSymptoms: Head throbbing + light sensitivity\nDoctor Notes: Stress-triggered pattern\nTreatment: Pain management medication prescribed\nAdvice: Reduce screen exposure and rest in dark room."
            ),
            Customer(
                "C103",
                "Amit Singh",
                "Sikandra, Agra, Uttar Pradesh",
                "Diabetes Checkup",
                "amit.singh@example.com",
                "9988776655",
                45,
                1,
                "Condition: Routine Diabetes Review\nSugar Levels: Stable\nDoctor Notes: Controlled condition\nTreatment: Continue existing medication\nAdvice: Maintain diet and daily walking routine."
            ),
            Customer(
                "C104",
                "Neha Gupta",
                "Shahganj, Agra, Uttar Pradesh",
                "Accident - Leg Injury",
                "neha.gupta@example.com",
                "8899776655",
                24,
                3,
                "Condition: Accident Trauma\nInjury: Suspected leg fracture\nDoctor Notes: Swelling + severe pain\nTreatment: X-ray advised, temporary splint applied\nAdvice: Avoid movement and immediate orthopedic consultation."
            ),
            Customer(
                "C105",
                "Vikas Yadav",
                "Taj Nagari Phase 2, Agra, Uttar Pradesh",
                "Routine Checkup",
                "vikas.yadav@example.com",
                "7766554433",
                36,
                1,
                "Condition: General Health Check\nVitals: Normal\nDoctor Notes: Physically fit\nTreatment: None required\nAdvice: Maintain active lifestyle and balanced diet."
            ),
            Customer(
                "C106",
                "Sonal Jain",
                "Loha Mandi, Agra, Uttar Pradesh",
                "Severe Skin Allergy",
                "sonal.jain@example.com",
                "6655443322",
                29,
                3,
                "Condition: Acute Skin Allergy\nSymptoms: Redness + itching patches\nDoctor Notes: Allergic trigger suspected\nTreatment: Steroid medication initiated\nAdvice: Avoid allergen exposure and monitor swelling."
            ),
            Customer(
                "C107",
                "Rakesh Chauhan",
                "Trans Yamuna Colony, Agra, Uttar Pradesh",
                "Back Pain",
                "rakesh.chauhan@example.com",
                "9090909090",
                50,
                2,
                "Condition: Chronic Back Pain\nSymptoms: Lower spine stiffness\nDoctor Notes: Muscle strain likely\nTreatment: Pain relief gel + medication\nAdvice: Start physiotherapy and avoid heavy lifting."
            ),
            Customer(
                "C108",
                "Anjali Mishra",
                "Fatehabad Road, Agra, Uttar Pradesh",
                "Accident - Head Injury",
                "anjali.mishra@example.com",
                "7878787878",
                27,
                3,
                "Condition: Head Injury Trauma\nSymptoms: Dizziness + mild bleeding\nDoctor Notes: Possible concussion\nTreatment: CT scan recommended\nAdvice: Observation for 24 hrs and avoid screen use."
            ),
            Customer(
                "C109",
                "Deepak Agarwal",
                "Belanganj, Agra, Uttar Pradesh",
                "Severe Blood Pressure",
                "deepak.agarwal@example.com",
                "8989898989",
                41,
                2,
                "Condition: High Blood Pressure\nReading: 160/100\nDoctor Notes: Stress-related spike\nTreatment: BP medication prescribed\nAdvice: Reduce salt intake and practice relaxation exercises."
            ),
            Customer(
                "C110",
                "Kavita Saxena",
                "Rajpur Chungi, Agra, Uttar Pradesh",
                "Thyroid Check",
                "kavita.saxena@example.com",
                "9797979797",
                38,
                1,
                "Condition: Thyroid Evaluation\nReport: Hormone levels normal\nDoctor Notes: Stable thyroid function\nTreatment: No medication change\nAdvice: Annual test recommended."
            )
        )
       return when(serverity){
            1 -> return customers.filter { it.diagnosisSeverityCode == 1 } as ArrayList<Customer>
            2 -> return customers.filter { it.diagnosisSeverityCode == 2 } as ArrayList<Customer>
            3 -> return customers.filter { it.diagnosisSeverityCode == 3 } as ArrayList<Customer>
            else -> customers
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CustomerListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CustomerListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    fun showCusotmerDetails(context: Context, customer: Customer) {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_remedy_details, null)

        val title = dialogView.findViewById<TextView>(R.id.tvTitle)
        val category = dialogView.findViewById<TextView>(R.id.tvCategory)

        title.text = customer.diagnosis
        category.text = when (customer.diagnosisSeverityCode) {
            1 -> "Normal Case"
            2 -> "Moderate Condition"
            3 -> "Emergency Case"
            else -> "Medical Case"
        }

        val webView = dialogView.findViewById<WebView>(R.id.webViewDescription)
        val btnClose = dialogView.findViewById<Button>(R.id.btnClose)


        webView.settings.javaScriptEnabled = false

        webView.loadDataWithBaseURL(
            null,
            buildHtml(customer),
            "text/html",
            "UTF-8",
            null
        )

        val alertDialog = AlertDialog.Builder(context, R.style.CustomAlertDialog)
            .setView(dialogView)
            .create()

        alertDialog.show()
        val window = alertDialog.window
        val params = window?.attributes
        val displayMetrics = resources.displayMetrics
        params?.width = (displayMetrics.widthPixels * 0.95).toInt()
        params?.height = (displayMetrics.heightPixels * 0.75).toInt()
        window?.attributes = params

        btnClose.setOnClickListener { alertDialog.dismiss() }
    }

    fun buildHtml(customer: Customer): String {
        return """
        <html>
        <body style="font-family:sans-serif; padding:8px;">

        <h3>Patient Details</h3>
        <p>
        <b>Name:</b> ${customer.name}<br>
        <b>Age:</b> ${customer.age}<br>
        <b>Address:</b> ${customer.address}<br>
        <b>Phone:</b> ${customer.phone}
        </p>

        <h3>Diagnosis Summary</h3>
        <p>${customer.treatmentSummary?.replace("\n","<br>")}</p>

        <h3>Care Instructions</h3>
        <ul>
            <li>Follow prescribed medication strictly</li>
            <li>Monitor symptoms regularly</li>
            <li>Consult doctor if condition worsens</li>
        </ul>

        <p><i>Note: This report is system generated for quick medical reference.</i></p>

        </body>
        </html>
    """.trimIndent()
    }

    override fun onCustomerSelect(customer: Customer) {
        context?.let { showCusotmerDetails(it, customer) }
    }
}