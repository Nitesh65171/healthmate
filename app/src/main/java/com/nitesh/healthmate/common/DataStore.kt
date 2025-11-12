package com.faishion.vaama.common

import android.content.Context
import android.content.SharedPreferences
import com.faishion.vaama.common.AppConstants.SHARE_PREF_FILE

object DataStore {

    fun setStringData(context: Context, key: String, value: String){
        val sharedPreferences: SharedPreferences = context.getSharedPreferences( SHARE_PREF_FILE,Context.MODE_PRIVATE)
        val editor:SharedPreferences.Editor =  sharedPreferences.edit()
        editor.putString(key,value)
        editor.apply()
        editor.commit()
    }


    fun getStringData(context: Context, key: String): String{
        val sharedPreferences: SharedPreferences = context.getSharedPreferences( SHARE_PREF_FILE,Context.MODE_PRIVATE)
        return sharedPreferences.getString(key, AppConstants.EMPTY_VALUE)?: AppConstants.EMPTY_VALUE
    }

    fun setBooleanData(context: Context, key: String, value: Boolean){
        val sharedPreferences: SharedPreferences = context.getSharedPreferences( SHARE_PREF_FILE,Context.MODE_PRIVATE)
        val editor:SharedPreferences.Editor =  sharedPreferences.edit()
        editor.putBoolean(key,value)
        editor.apply()
        editor.commit()
    }

    fun getBooleanData(context: Context, key: String): Boolean{
        val sharedPreferences: SharedPreferences = context.getSharedPreferences( SHARE_PREF_FILE,Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean(key, false)
    }




}