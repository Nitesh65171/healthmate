package com.nitesh.healthmate.base

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.faishion.vaama.common.AppConstants
import com.faishion.vaama.common.DataStore
import com.nitesh.healthmate.R

/**
 * A simple [Fragment] subclass.
 * Use the [HealthMateBaseFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
open class HealthMateBaseFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*arguments?.let {
            param1 = it.getString(com.faishion.vaama.app.ARG_PARAM1)
            param2 = it.getString(com.faishion.vaama.app.ARG_PARAM2)
        }*/
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_healthmate_base, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkPermissions()

    }

    fun getStringValue(key: String): String{
        return context?.let { DataStore.getStringData(it, key) }?: AppConstants.EMPTY_VALUE
    }

    fun setStringValue(key: String, value: String){
        context?.let { DataStore.setStringData(it, key, value) }
    }

    fun getBooleanValue(key: String): Boolean{
        return context?.let { DataStore.getBooleanData(it, key) }?: false
    }

    fun setBooleanValue(key: String, value: Boolean){
        context?.let { DataStore.setBooleanData(it, key, value) }
    }


    fun hideActionBar(){

    }

    fun setHamburgerIcon(){

    }

    fun showActionBar(){

    }


    fun hideBackButton(){

    }

    fun showBackButton(){

    }

    fun setTitle(title: String){

    }

    fun logoutUser(): LinearLayout? {

        return null
    }

    fun getCustomerActionButton(): LinearLayout? {
        return null
    }


    private fun checkPermissions() {
        if (context?.let { ContextCompat.checkSelfPermission(it, Manifest.permission.CAMERA) }
            != PackageManager.PERMISSION_GRANTED) {
            activity?.let {
                ActivityCompat.requestPermissions(
                    it,
                    arrayOf(Manifest.permission.CAMERA),
                    101
                )
            }
        }
    }


    fun showProgress( msg: String? = null) {

    }

    fun hideProgress(){

    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment VaamaBaseFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic fun newInstance(param1: String, param2: String) =
                HealthMateBaseFragment().apply {
                    /*arguments = Bundle().apply {
                        putString(com.faishion.vaama.app.ARG_PARAM1, param1)
                        putString(com.faishion.vaama.app.ARG_PARAM2, param2)
                    }*/
                }
    }
}