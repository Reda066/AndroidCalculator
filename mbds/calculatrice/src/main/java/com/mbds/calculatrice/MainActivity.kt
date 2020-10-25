package com.mbds.calculatrice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import com.mbds.calculatrice.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(baseContext))
        setContentView(binding.root)

        //Chiffres
        binding.button0.setOnClickListener { Expression("1", true) }
        binding.button1.setOnClickListener { Expression("2", true) }
        binding.button2.setOnClickListener { Expression("3", true) }
        binding.button3.setOnClickListener { Expression("3", true) }
        binding.button4.setOnClickListener { Expression("4", true) }
        binding.button5.setOnClickListener { Expression("5", true) }
        binding.button6.setOnClickListener { Expression("6", true) }
        binding.button7.setOnClickListener { Expression("7", true) }
        binding.button8.setOnClickListener { Expression("8", true) }
        binding.button9.setOnClickListener { Expression("9", true) }
        binding.buttonPoint.setOnClickListener { Expression(".", true) }

        //Operateurs
        binding.buttonPlus.setOnClickListener { Expression("+", false) }
        binding.buttonMoins.setOnClickListener { Expression("-", false) }
        binding.buttonMultiple.setOnClickListener { Expression("*", false) }
        binding.buttonDiviser.setOnClickListener { Expression("/", false) }
        binding.buttonParenthDroite.setOnClickListener { Expression(")", false) }
        binding.buttonParenthGauche.setOnClickListener { Expression("(", false) }

        binding.buttonCE.setOnClickListener {
            binding.Expression.text = ""
            binding.Resultat.text = ""
        }

        binding.buttonEgal.setOnClickListener {
            try {

                val expression = ExpressionBuilder(binding.Expression.text.toString()).build()
                val resultat = expression.evaluate()
                val longResultat = resultat.toLong()
                if (resultat == longResultat.toDouble())
                    binding.Resultat.text = longResultat.toString()
                else
                    binding.Resultat.text = resultat.toString()

            } catch (e: Exception) {
                Log.d("Erreur", " message : " + e.message)
            }
        }

        binding.buttonPercent.setOnClickListener {
            var no: Double = binding.Expression.text.toString().toDouble() / 100
            binding.Expression.setText(no.toString())
            binding.Resultat.text = ""

        }

    }

    fun Expression(string: String, canClear: Boolean) {

        if (binding.Resultat.text.isNotEmpty()) {
            binding.Expression.text = ""
        }

        if (canClear) {
            binding.Resultat.text = ""
            binding.Expression.append(string)
        } else {
            binding.Expression.append(binding.Resultat.text)
            binding.Expression.append(string)
            binding.Resultat.text = ""
        }
    }
}