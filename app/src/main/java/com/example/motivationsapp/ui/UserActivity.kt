package com.example.motivationsapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.motivationsapp.R
import com.example.motivationsapp.SecurityPreferences
import com.example.motivationsapp.databinding.ActivityUserBinding
import com.example.motivationsapp.infra.MotivationConstants

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.buttonSave.setOnClickListener(this)

        verifyUserName()

    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_save) {
            handleSave()
        }
    }

    private fun verifyUserName() {
        val userName = SecurityPreferences(this).getString(MotivationConstants.KEYS.USER_NAME)
        if (userName != "") {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun handleSave() {
        val name = binding.editUserName.text.toString()
        if (name != "") {
            SecurityPreferences(this).saveString(MotivationConstants.KEYS.USER_NAME, name)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else {
            Toast.makeText(this, R.string.validation_mandatory_name, Toast.LENGTH_SHORT).show()
        }
    }
}