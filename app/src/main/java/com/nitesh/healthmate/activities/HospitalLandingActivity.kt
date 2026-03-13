package com.nitesh.healthmate.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.nitesh.healthmate.R
import com.nitesh.healthmate.base.BaseHealthmateActivity
import com.nitesh.healthmate.databinding.ActivityLandingBinding
import androidx.navigation.ui.setupWithNavController
import com.nitesh.healthmate.databinding.ActivityHospitalLandingBinding
import com.nitesh.healthmate.hospitalsection.fragment.RequestListFragment
import com.nitesh.healthmate.hospitalsection.model.AlertRequest
import com.nitesh.healthmate.hospitalsection.model.AlertStatus

class HospitalLandingActivity : BaseHealthmateActivity() {
    lateinit var binding: ActivityHospitalLandingBinding
    lateinit var titleView: TextView
    private val handler = android.os.Handler(android.os.Looper.getMainLooper())
    private var emergencyRunnable: Runnable? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital_landing)
        enableEdgeToEdge()
        binding = ActivityHospitalLandingBinding.inflate(layoutInflater)
        val navView = findViewById<BottomNavigationView>(R.id.hospital_bottomNavigationView)
        titleView = findViewById<TextView?>(R.id.title)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        // Connect BottomNavigationView with NavController
        navView.setupWithNavController(navController)
        setupActionBar()
        hideActionBar()

    }

    override fun onResume() {
        super.onResume()
        val countDownTimer = object : CountDownTimer(20000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // You can update a UI element here to show the countdown if needed
            }

            override fun onFinish() {
                shodEmergencyRequest()
            }
        }
        countDownTimer.start()
    }

    private fun setupActionBar() {
        supportActionBar?.apply {
            setDisplayShowCustomEnabled(true)  // Enable custom view
            setDisplayShowTitleEnabled(false) // Hide default title
            customView = LayoutInflater.from(this@HospitalLandingActivity)
                .inflate(R.layout.action_bar, null)
        }

        setTitle("New Title")
        showBackButton()
    }

    override fun setTitle(title: CharSequence?) {
        titleView.setText(title)
    }


    fun showActionBar() = supportActionBar?.show()
    fun hideActionBar() = supportActionBar?.hide()

    fun hideBackButton() = supportActionBar?.apply {
        setDisplayHomeAsUpEnabled(false)
        setHomeAsUpIndicator(R.drawable.left_arrow_icon)
    }

    fun showBackButton() = supportActionBar?.apply {
        setDisplayHomeAsUpEnabled(true)
        setHomeAsUpIndicator(R.drawable.left_arrow_icon)
    }



    fun shodEmergencyRequest() {

        emergencyRunnable = object : Runnable {

            override fun run() {

                // Inflate dialog layout
                val view = layoutInflater.inflate(R.layout.emergency_request_pop_up, null)

                // Bind Views
                val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
                val tvSeverity = view.findViewById<TextView>(R.id.tvSeverity)
                val tvNameAge = view.findViewById<TextView>(R.id.tvNameAge)
                val tvEmergencyType = view.findViewById<TextView>(R.id.tvEmergencyType)
                val tvSymptoms = view.findViewById<TextView>(R.id.tvSymptoms)
                val tvDescription = view.findViewById<TextView>(R.id.tvDescription)
                val tvAddress = view.findViewById<TextView>(R.id.tvAddress)
                val tvPhone = view.findViewById<TextView>(R.id.tvPhone)
                val tvAltPhone = view.findViewById<TextView>(R.id.tvAltPhone)
                val btnAccept = view.findViewById<Button>(R.id.btnAccept)
                val btnReject = view.findViewById<Button>(R.id.btnReject)
                val btnMap = view.findViewById<Button>(R.id.btnOpenMap)

                // Dummy Emergency Data (replace with API / socket data)
                val lat = 27.1767
                val lng = 78.0081

                tvTitle.text = "New Emergency Request"
                tvSeverity.text = "Emergency"
                tvNameAge.text = "Rohit Sharma • 34 yrs"
                tvEmergencyType.text = "Type: Fire Burn Injury"
                tvSymptoms.text = "Symptoms: Burns, breathing difficulty"
                tvDescription.text = "Description: Patient trapped near factory fire, urgent help required."
                tvAddress.text = "Industrial Area, Sikandra, Agra"
                tvPhone.text = "Primary: 9876543210"
                tvAltPhone.text = "Alternate: 9123456789"

                // Open Google Maps
                btnMap.setOnClickListener {
                    val uri = Uri.parse("geo:$lat,$lng?q=$lat,$lng")
                    startActivity(Intent(Intent.ACTION_VIEW, uri))
                }

                val dialog = android.app.AlertDialog.Builder(this@HospitalLandingActivity)
                    .setView(view)
                    .setCancelable(false)
                    .create()

                btnAccept.setOnClickListener {
                    val alertRequest = AlertRequest(
                        alertId = "ALT" + System.currentTimeMillis(),
                        patientId = "P102",
                        patientName = "Rohit Sharma",
                        age = 34,

                        severityLevel = 3,
                        emergencyType = "Fire Burn Injury",
                        diagnosis = "Severe burns with breathing distress",

                        description = "Patient trapped near factory fire, requires immediate emergency response.",
                        symptoms = listOf("Burns", "Breathing difficulty", "Shock"),

                        latitude = 27.1767,
                        longitude = 78.0081,
                        address = "Industrial Area, Sikandra, Agra, Uttar Pradesh",

                        contactNumber = "9876543210",
                        alternateContact = "9123456789",

                        requestedHospitalId = "H001",
                        assignedHospitalId = "H001",

                        assignedDoctorId = null,
                        assignedAmbulanceId = null,

                        status = AlertStatus.ACCEPTED,
                        createdAt = System.currentTimeMillis(),
                        acceptedAt = System.currentTimeMillis(),
                        completedAt = null,

                        requiresAmbulance = true,
                        requiresICU = false,

                        attachments = null
                    )

                    val bundle = Bundle().apply {
                        putParcelable("ALERT_KEY", alertRequest)
                    }

                    val navHostFragment =
                        supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

                    val navController = navHostFragment.navController
                    navController.navigate(R.id.action_request_details, bundle)

                    Toast.makeText(applicationContext, "Request Accepted", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }

                btnReject.setOnClickListener {

                    Toast.makeText(applicationContext, "Request Rejected", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }

                val navHostFragment =
                    supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

                val currentFragment =
                    navHostFragment.childFragmentManager.fragments.firstOrNull()
                if(currentFragment is RequestListFragment){
                    dialog.show()
                }


                // Repeat every 15 seconds
                handler.postDelayed(this, 20000)
            }
        }

        handler.post(emergencyRunnable!!)
    }
}