package com.mbds.tp.ui.login

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.mbds.tp.MainActivity

import com.mbds.tp.R
import com.mbds.tp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    // lateinit = je vais initialiser plus tard et notre responsabilité est de le faire au bon moment

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(LayoutInflater.from(baseContext))
        setContentView(binding.root)
        binding.login.setOnClickListener {
            handleClick()
        }
    }

    private fun handleClick()
    {
        // pour lancer activite créer une intention, faire lien entre layout et code java
        if (!binding.email.text.isNullOrBlank() && !binding.password.text.isNullOrBlank()) {
            val intent = Intent(baseContext, MainActivity::class.java)
            startActivity(intent)
        } else {
            //Toast affiche un message pendant une certaine durée
            Toast.makeText(
                baseContext,
                "Veuillez remplir tous les champs svp frère !",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}