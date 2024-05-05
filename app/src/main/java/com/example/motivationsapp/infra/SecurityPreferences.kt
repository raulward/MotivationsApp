package com.example.motivationsapp.infra

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences(context: Context) {

    private val security: SharedPreferences =
        context.getSharedPreferences("Motivations", Context.MODE_PRIVATE)

    fun saveString(key: String, str: String) {
        security.edit().putString(key, str).apply()
    }

    fun getString(key: String) : String {
       return security.getString(key, "") ?: ""
    }

    fun deleteString(key: String) {
        security.edit().putString(key, "").apply()
    }

}