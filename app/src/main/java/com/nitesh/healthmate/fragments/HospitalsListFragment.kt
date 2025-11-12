package com.nitesh.healthmate.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.faishion.vaama.orders.adapter.HospitalListAdapter
import com.faishion.vaama.orders.adapter.HospitalListAdapter.HospitalSelectClickListner
import com.nitesh.healthmate.R
import com.nitesh.healthmate.activities.LandingActivity
import com.nitesh.healthmate.databinding.FragmentHospitalsListBinding
import com.nitesh.healthmate.model.Hospital

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HospitalsListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HospitalsListFragment : Fragment(), HospitalSelectClickListner {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentHospitalsListBinding

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
        // Inflate the layout for this fragment
        binding = FragmentHospitalsListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as LandingActivity).setTitle("Hospitals")
        val hospitals = arrayListOf<Hospital>(
            Hospital(hospitalId = "12345", hospitalName =  "Apex multi-speciality hospital", contact = "987656789",  rating = 4),
            Hospital(hospitalId = "453434", hospitalName =  "Shanti Ved Hospital", contact = "86767676",  rating = 4),
            Hospital(hospitalId = "454343", hospitalName =  "Kamlesh Tandon Nursing Home", contact = "987656789",  rating = 4),
            Hospital(hospitalId = "632355", hospitalName =  "Agarwal Eye Care Hospital", contact = "987656789",  rating = 4),
            Hospital(hospitalId = "768876", hospitalName =  "Pushpanjali Hospital & Research Centre", contact = "987656789",  rating = 4),
            Hospital(hospitalId = "878565", hospitalName =  "Anand Mangal Hospital", contact = "987656789",  rating = 4),
            Hospital(hospitalId = "988967", hospitalName =  "AMahajan Hospital", contact = "987656789",  rating = 4),
            Hospital(hospitalId = "133435", hospitalName =  "Rainbow Global Healthcare Hospital", contact = "987656789",  rating = 4),
            Hospital(hospitalId = "657645", hospitalName =  "Asopa Hospital", contact = "987656789",  rating = 4),
            Hospital(hospitalId = "764544", hospitalName =  "Lady Lyall Hospital", contact = "987656789",  rating = 4),
            Hospital(hospitalId = "123445", hospitalName =  "District Hospital, Agra", contact = "987656789",  rating = 4),
            Hospital(hospitalId = "877945", hospitalName =  "Mental Hospital, Agra", contact = "987656789",  rating = 4),
            Hospital(hospitalId = "654534", hospitalName =  "Agra Heart Centre", contact = "987656789",  rating = 4),
        )
        val hospitalList = HospitalListAdapter(context, hospitals, this)
        binding.hospitalRv.adapter = hospitalList
        binding.hospitalRv.layoutManager = LinearLayoutManager(context)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HospitalsListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HospitalsListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onHospitalSelect(hospital: Hospital) {
       view?.let {  findNavController(it).navigate(R.id.action_book_appointment)}
    }
}