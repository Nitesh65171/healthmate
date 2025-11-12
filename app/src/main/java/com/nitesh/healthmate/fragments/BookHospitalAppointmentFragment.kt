package com.nitesh.healthmate.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.nitesh.healthmate.R
import com.nitesh.healthmate.activities.LandingActivity
import com.nitesh.healthmate.databinding.FragmentBookHospitalAppointmentBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BookHospitalAppointmentFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BookHospitalAppointmentFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentBookHospitalAppointmentBinding

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
        binding = FragmentBookHospitalAppointmentBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as LandingActivity).setTitle("Book appointment")
        binding.appointmentDate.setOnClickListener {
            context?.let { it1 ->
                openDatePicker(it1, {
                    binding.appointmentDate.setText(it)
                })
            }
        }

        binding.appointmentTime.setOnClickListener {
            context?.let { it1 ->
                openTimePicker(it1, {
                    binding.appointmentTime.setText(it)
                })
            }
        }

        binding.btnBookAppointment.setOnClickListener {
            showAppointmentSuccessDialog()
        }
    }

    fun openDatePicker(context: Context, onDateSelected: (String) -> Unit) {
        val datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select Appointment Date")
            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .build()

        datePicker.addOnPositiveButtonClickListener { selection ->
            val formatter = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
            val dateString = formatter.format(Date(selection))
            onDateSelected(dateString)
        }

        datePicker.show((context as AppCompatActivity).supportFragmentManager, "DATE_PICKER")
    }


    fun openTimePicker(context: Context, onTimeSelected: (String) -> Unit) {
        val picker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_12H)
            .setHour(9)
            .setMinute(0)
            .setTitleText("Select Appointment Time")
            .build()

        picker.addOnPositiveButtonClickListener {
            val hour = picker.hour
            val minute = picker.minute
            val amPm = if (hour >= 12) "PM" else "AM"
            val formattedHour = if (hour % 12 == 0) 12 else hour % 12
            val formattedTime = String.format("%02d:%02d %s", formattedHour, minute, amPm)
            onTimeSelected(formattedTime)
        }

        picker.show((context as AppCompatActivity).supportFragmentManager, "TIME_PICKER")
    }

    fun showAppointmentSuccessDialog() {
        // Step 1: Show a loading dialog first
        val loadingDialog = AlertDialog.Builder(requireContext())
            .setView(R.layout.dialog_loading)
            .setCancelable(false)
            .create()

        loadingDialog.show()

        // Step 2: After small delay, show success
        CoroutineScope(Dispatchers.Main).launch {
            delay(2000) // simulate booking time (2 sec)
            loadingDialog.dismiss()

            val dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_success, null)
            val successDialog = AlertDialog.Builder(requireContext())
                .setView(dialogView)
                .setCancelable(true)
                .create()

            successDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            successDialog.show()
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BookHospitalAppointmentFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BookHospitalAppointmentFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}