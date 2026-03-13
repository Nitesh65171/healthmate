package com.nitesh.healthmate.hospitalsection.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.faishion.vaama.orders.adapter.CustomerListAdapter
import com.nitesh.healthmate.R
import com.nitesh.healthmate.activities.HospitalLandingActivity
import com.nitesh.healthmate.databinding.FragmentCustomerListBinding
import com.nitesh.healthmate.databinding.FragmentRequestListBinding
import com.nitesh.healthmate.hospitalsection.adapter.RequestListAdapter
import com.nitesh.healthmate.hospitalsection.model.AlertRequest
import com.nitesh.healthmate.hospitalsection.model.AlertStatus
import com.nitesh.healthmate.model.Customer
import com.nitesh.healthmate.model.DiagnosisSeverity
import java.util.ArrayList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RequestListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RequestListFragment : Fragment(), RequestListAdapter.RequestListSelectClickListner {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentRequestListBinding

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
        binding = FragmentRequestListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity is HospitalLandingActivity){
            (activity as HospitalLandingActivity).title = "Emergency Requests"
        }
        val alertRequest = alertRequests()
        val customerListAdapter = RequestListAdapter(context, alertRequest, this)
        binding.requestRv.adapter = customerListAdapter
        binding.requestRv.layoutManager = LinearLayoutManager(context)
    }

    private fun alertRequests(): ArrayList<AlertRequest> {

        val now = System.currentTimeMillis()

        return arrayListOf(

            AlertRequest(
                "AL001","C201","Rohit Chauhan",29,
                3,"Road Accident","Severe Head Trauma",
                "Bike collision with truck, unconscious",
                listOf("Bleeding","Head Injury","Unconscious"),
                27.1767,78.0081,"NH-19 Highway, Agra",
                "9011111111","9022222222",
                "HOSP001","HOSP001",
                "DOC01","AMB01",
                AlertStatus.IN_PROGRESS,
                now-600000,now-550000,null,
                true,true,null
            ),

            AlertRequest(
                "AL002","C202","Anita Verma",34,
                3,"Fire Accident","Severe Burns",
                "Kitchen cylinder blast burn injury",
                listOf("Burns","Skin Peeling","Pain"),
                27.1800,78.0200,"Kamla Nagar, Agra",
                "9033333333",null,
                "HOSP002","HOSP002",
                "DOC02","AMB02",
                AlertStatus.ACCEPTED,
                now-500000,now-470000,null,
                true,true,null
            ),

            AlertRequest(
                "AL003","C203","Mukesh Yadav",41,
                3,"Industrial Accident","Hand Crush Injury",
                "Machine accident at factory",
                listOf("Fracture","Bleeding","Shock"),
                27.2100,78.0100,"Foundry Nagar, Agra",
                "9044444444","9055555555",
                "HOSP003","HOSP003",
                "DOC03","AMB03",
                AlertStatus.IN_PROGRESS,
                now-700000,now-650000,null,
                true,false,null
            ),

            AlertRequest(
                "AL004","C204","Pooja Singh",22,
                3,"Fire Smoke Inhalation","Breathing Failure",
                "House fire exposure",
                listOf("Breathing Difficulty","Cough","Chest Tightness"),
                27.1700,78.0500,"Shahganj, Agra",
                "9066666666",null,
                "HOSP001","HOSP001",
                "DOC04","AMB04",
                AlertStatus.ACCEPTED,
                now-300000,now-250000,null,
                true,true,null
            ),

            AlertRequest(
                "AL005","C205","Vikram Patel",37,
                3,"Construction Accident","Spinal Injury",
                "Fell from 2nd floor",
                listOf("Back Pain","Immobility","Bleeding"),
                27.1500,78.0700,"Sikandra Site Area",
                "9077777777",null,
                "HOSP004","HOSP004",
                "DOC05","AMB05",
                AlertStatus.IN_PROGRESS,
                now-400000,now-360000,null,
                true,true,null
            ),

            AlertRequest(
                "AL006","C206","Neha Kapoor",31,
                2,"Minor Accident","Arm Fracture",
                "Scooty slipped on road",
                listOf("Pain","Swelling"),
                27.1950,78.0450,"Belanganj, Agra",
                "9088888888",null,
                null,null,null,null,
                AlertStatus.PENDING,
                now-200000,null,null,
                true,false,null
            ),

            AlertRequest(
                "AL007","C207","Arjun Tiwari",48,
                3,"Electrical Shock","Cardiac Disturbance",
                "High voltage shock while repairing line",
                listOf("Burn Marks","Unstable Pulse"),
                27.2050,78.0350,"Trans Yamuna Colony",
                "9099999999","9010101010",
                "HOSP002","HOSP002",
                "DOC06","AMB06",
                AlertStatus.IN_PROGRESS,
                now-900000,now-850000,null,
                true,true,null
            ),

            AlertRequest(
                "AL008","C208","Sanjay Agarwal",52,
                3,"Road Accident","Multiple Fractures",
                "Car rollover on highway",
                listOf("Fractures","Bleeding","Shock"),
                27.2300,78.0200,"Agra-Lucknow Expressway",
                "9111111111","9222222222",
                "HOSP001","HOSP001",
                "DOC07","AMB07",
                AlertStatus.ACCEPTED,
                now-1000000,now-960000,null,
                true,true,null
            ),

            AlertRequest(
                "AL009","C209","Ritu Sharma",27,
                3,"Fire Explosion","Critical Burns",
                "Factory chemical explosion",
                listOf("Burns","Breathing Issue","Shock"),
                27.1850,78.0600,"Industrial Area, Agra",
                "9333333333",null,
                "HOSP003","HOSP003",
                "DOC08","AMB08",
                AlertStatus.IN_PROGRESS,
                now-120000,now-100000,null,
                true,true,null
            ),

            AlertRequest(
                "AL010","C210","Mahesh Singh",60,
                2,"Fall Injury","Hip Injury",
                "Slipped in bathroom",
                listOf("Pain","Cannot Walk"),
                27.1600,78.0350,"Rajpur Chungi, Agra",
                "9444444444",null,
                null,null,null,null,
                AlertStatus.PENDING,
                now-150000,null,null,
                true,false,null
            ),

            AlertRequest(
                "AL011","C211","Deepak Jain",45,
                3,"Gas Leak","Poisoning",
                "Inhaled LPG gas",
                listOf("Dizziness","Vomiting","Breathlessness"),
                27.1805,78.0155,"Dayalbagh, Agra",
                "9555555555","9666666666",
                "HOSP004","HOSP004",
                "DOC09","AMB09",
                AlertStatus.ACCEPTED,
                now-60000,now-30000,null,
                true,true,null
            ),

            AlertRequest(
                "AL012","C212","Sonia Mishra",39,
                3,"Bus Accident","Severe Trauma",
                "Passenger injured in bus crash",
                listOf("Bleeding","Shock","Head Injury"),
                27.2000,78.0550,"MG Road, Agra",
                "9777777777",null,
                "HOSP002","HOSP002",
                "DOC10","AMB10",
                AlertStatus.IN_PROGRESS,
                now-50000,now-20000,null,
                true,true,null
            )
        )
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProgressCaseListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RequestListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onRequestSelected(alert: AlertRequest) {
        val bundle = Bundle()
        bundle.putParcelable("ALERT_KEY", alert)
        view?.let {  findNavController(it).navigate(R.id.action_request_details, bundle)}
    }
}