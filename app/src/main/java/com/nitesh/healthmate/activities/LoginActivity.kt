package com.nitesh.healthmate.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContentProviderCompat.requireContext
import com.nitesh.healthmate.R
import com.nitesh.healthmate.base.BaseHealthmateActivity
import com.nitesh.healthmate.databinding.LoginActivityBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginActivity : BaseHealthmateActivity(), OnClickListener {
    lateinit var binding: LoginActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        binding = LoginActivityBinding.inflate(layoutInflater)
        var loginButton = findViewById<Button>(R.id.login_btn)
        loginButton.setOnClickListener {
            val username = findViewById<EditText>(R.id.user_name_ed).text
            val password = findViewById<EditText>(R.id.password_ed).text
            if (username.isNullOrEmpty() || password.isNullOrEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "Please provide user name and password..!!",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            startLoginProcess()


        }
        binding.signUpLink.setOnClickListener(this)

    }

    private fun startLoginProcess() {
        // Step 1: Show a loading dialog first
        val view = LayoutInflater.from(this@LoginActivity).inflate(R.layout.dialog_loading, null)
        view.findViewById<TextView>(R.id.progress_dialog_title).text = "Login progress..."
        val loadingDialog = AlertDialog.Builder(this@LoginActivity)
            .setView(view)
            .setCancelable(false)
            .create()

        loadingDialog.show()
        // Step 2: After small delay, show success
        CoroutineScope(Dispatchers.Main).launch {
            delay(2000) // simulate booking time (2 sec)
            loadingDialog.dismiss()
            startActivity(Intent(this@LoginActivity, LandingActivity::class.java))
            finish()
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.login_btn -> {
                startActivity(Intent(this, LandingActivity::class.java))
                finish()
            }

            else -> {
                Log.d("app_log", "log triggered")
            }
        }
    }
}
