package com.example.motivationsapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.motivationsapp.R
import com.example.motivationsapp.infra.SecurityPreferences
import com.example.motivationsapp.data.Mock
import com.example.motivationsapp.databinding.ActivityMainBinding
import com.example.motivationsapp.infra.MotivationConstants

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var categoryId = MotivationConstants.FILTER.INFINITE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Hide navigation bar
        supportActionBar?.hide()

        // Altera o nome de usuário
        handleUserName()

        // Define o All como o elemento padrao
        handleFilter(R.id.image_infinite)

        // Define uma frase de inicio
        binding.textPhrase.text = Mock.handlePhrase(categoryId)

        // Events
        binding.buttonNewPhrase.setOnClickListener(this)
        binding.imageInfinite.setOnClickListener(this)
        binding.imageSmile.setOnClickListener(this)
        binding.imageSun.setOnClickListener(this)
        binding.textUser.setOnClickListener(this)




    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_new_phrase) {
            binding.textPhrase.text = Mock.handlePhrase(categoryId)
        } else if (v.id in listOf(R.id.image_infinite, R.id.image_smile, R.id.image_sun)) {
            handleFilter(v.id)
        } else if (v.id == R.id.text_user) {
            handleUserNameClick()
        }
    }

    private fun handleUserName() {
        val userName = SecurityPreferences(this).getString(MotivationConstants.KEYS.USER_NAME)
        binding.textUser.text = "Olá, $userName!"
    }

    private fun handleUserNameClick() {
        SecurityPreferences(this).deleteString(MotivationConstants.KEYS.USER_NAME)
        startActivity(Intent(this, UserActivity::class.java))
    }

    private fun handleFilter(id: Int) {

        binding.imageInfinite.setColorFilter(ContextCompat.getColor(this, R.color.purple))
        binding.imageSmile.setColorFilter(ContextCompat.getColor(this, R.color.purple))
        binding.imageSun.setColorFilter(ContextCompat.getColor(this, R.color.purple))


        when (id) {
            R.id.image_infinite -> {
                binding.imageInfinite.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.INFINITE
            }
            R.id.image_smile -> {
                binding.imageSmile.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.HAPPY
            }
            R.id.image_sun -> {
                binding.imageSun.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.SUN
            }
        }
    }


}