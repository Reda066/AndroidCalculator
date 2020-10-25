package com.mbds.calculatrice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import com.mbds.calculatrice.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var operation: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(baseContext))
        setContentView(binding.root)

        //chiffres
        binding.button0.setOnClickListener { Expression("1",true) }
        binding.button1.setOnClickListener { Expression("2",true) }
        binding.button2.setOnClickListener { Expression("3",true) }
        binding.button3.setOnClickListener { Expression("3",true) }
        binding.button4.setOnClickListener { Expression("4",true) }
        binding.button5.setOnClickListener { Expression("5",true) }
        binding.button6.setOnClickListener { Expression("6",true) }
        binding.button7.setOnClickListener { Expression("7",true) }
        binding.button8.setOnClickListener { Expression("8",true) }
        binding.button9.setOnClickListener { Expression("9",true) }

        //Operateurs
        binding.buttonPlus.setOnClickListener { Expression("+", false) }
        binding.buttonMoins.setOnClickListener { Expression("-", false) }
        binding.buttonMultiple.setOnClickListener { Expression("*", false) }
        binding.buttonDiviser.setOnClickListener { Expression("/", false) }

binding.buttonEgal.setOnClickListener {
        try {

                val expression = ExpressionBuilder(binding.Expression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if(result == longResult.toDouble())
                    binding.Resultat.text = longResult.toString()
                else
                    binding.Resultat.text = result.toString()

            }catch (e:Exception){
                Log.d("Erreur"," message : " + e.message )
            }
        }
    }

    fun Expression(string: String, canClear: Boolean) {

        if(binding.Resultat.text.isNotEmpty()){
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