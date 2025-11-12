package com.nitesh.healthmate.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.nitesh.healthmate.R
import com.nitesh.healthmate.base.BaseHealthmateActivity
import com.nitesh.healthmate.databinding.ActivityLandingBinding
import androidx.navigation.ui.setupWithNavController

class LandingActivity : BaseHealthmateActivity() {
    lateinit var binding: ActivityLandingBinding
    lateinit var titleView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)
        enableEdgeToEdge()
        binding = ActivityLandingBinding.inflate(layoutInflater)
        val navView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        titleView = findViewById<TextView?>(R.id.title)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        // Connect BottomNavigationView with NavController
        navView.setupWithNavController(navController)
        setupActionBar()
        hideActionBar()

    }

    private fun setupActionBar() {
        supportActionBar?.apply {
            setDisplayShowCustomEnabled(true)  // Enable custom view
            setDisplayShowTitleEnabled(false) // Hide default title
            customView = LayoutInflater.from(this@LandingActivity)
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
}