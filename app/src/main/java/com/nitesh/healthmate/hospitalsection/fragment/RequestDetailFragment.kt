package com.nitesh.healthmate.hospitalsection.fragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import com.nitesh.healthmate.databinding.FragmentRequestDetailBinding
import com.nitesh.healthmate.hospitalsection.model.AlertRequest

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RequestDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RequestDetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentRequestDetailBinding

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
        binding = FragmentRequestDetailBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val alertRequest: AlertRequest? = arguments?.getParcelable("ALERT_KEY")
        if (alertRequest != null) {
            setRequestData(alertRequest)
        }

    }


    fun setRequestData(request: AlertRequest) {

        setSeverityColor(request.severityLevel)

        /* ---------------- HEADER ---------------- */

        binding.tvSeverity.text = when(request.severityLevel){
            3 -> "EMERGENCY"
            2 -> "URGENT"
            else -> "NORMAL"
        }

        binding.tvEmergencyType.text = request.emergencyType ?: "Unknown Emergency"

        binding.tvTime.text = getTimeAgo(request.createdAt)


        /* ---------------- PATIENT INFO ---------------- */

        binding.tvName.text = request.patientName ?: "Unknown Patient"
        binding.tvAge.text = "Age: ${request.age ?: "--"}"
        binding.tvContact.text = "Contact: ${request.contactNumber ?: "--"}"
        binding.tvAltContact.text = "Alternate: ${request.alternateContact ?: "--"}"


        /* ---------------- DIAGNOSIS ---------------- */

        binding.tvDiagnosis.text = request.diagnosis ?: "Not Available"

        binding.tvSymptoms.text =
            request.symptoms?.joinToString(", ") ?: "No symptoms reported"

        binding.tvNotes.text = request.description ?: "No notes"


        /* ---------------- LOCATION ---------------- */

        binding.tvAddress.text = request.address ?: "Location unavailable"

        binding.tvCoordinates.text =
            "${request.latitude} , ${request.longitude}"


        /* ---------------- ASSIGNMENT ---------------- */

        binding.tvHospital.text =
            "Hospital: ${request.assignedHospitalId ?: "Not Assigned"}"

        binding.tvDoctor.text =
            "Doctor: ${request.assignedDoctorId ?: "Not Assigned"}"

        binding.tvAmbulance.text =
            "Ambulance: ${request.assignedAmbulanceId ?: "Not Assigned"}"

        binding.tvStatus.text = "Status: ${request.status.name.replace("_"," ")}"


        /* ---------------- TIMELINE ---------------- */

        binding.tvRequestedTime.text =
            "Requested: ${formatTime(request.createdAt)}"

        binding.tvAcceptedTime.text =
            "Accepted: ${request.acceptedAt?.let { formatTime(it) } ?: "--"}"

        binding.tvCompletedTime.text =
            "Completed: ${request.completedAt?.let { formatTime(it) } ?: "--"}"


        /* ---------------- MAP BUTTON ---------------- */

        binding.btnOpenMap.setOnClickListener {
            openMap(request.latitude, request.longitude)
        }
    }

    private fun openMap(lat: Double, lng: Double) {

        val uri = Uri.parse("geo:$lat,$lng?q=$lat,$lng")
        val intent = Intent(Intent.ACTION_VIEW, uri)

        intent.setPackage("com.google.android.apps.maps")

        try {
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(requireContext(),"Google Maps not installed",Toast.LENGTH_SHORT).show()
        }
    }

    private fun formatTime(time: Long): String {
        val sdf = SimpleDateFormat("hh:mm a", Locale.getDefault())
        return sdf.format(Date(time))
    }

    private fun getTimeAgo(time: Long): String {

        val diff = System.currentTimeMillis() - time

        val minutes = diff / 60000
        val hours = minutes / 60

        return when {
            minutes < 1 -> "Just now"
            minutes < 60 -> "$minutes mins ago"
            hours < 24 -> "$hours hrs ago"
            else -> SimpleDateFormat("dd MMM hh:mm a", Locale.getDefault()).format(Date(time))
        }
    }

    private fun setSeverityColor(level: Int){
        val color = when(level){
            3 -> Color.parseColor("#D32F2F")
            2 -> Color.parseColor("#FFA000")
            else -> Color.parseColor("#388E3C")
        }
        binding.tvSeverity.setBackgroundColor(color)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RequestDetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RequestDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}