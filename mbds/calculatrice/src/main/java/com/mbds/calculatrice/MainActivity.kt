package com.mbds.calculatrice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.mbds.calculatrice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var operation: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    fun numberEvent(view: View) {
        var buclick = binding.Expression.text.toString()
        var buselect = view as Button
        when(buselect.id) {
            binding.button1.id -> {buclick += "1"}
            binding.button2.id -> {buclick += "2"}
            binding.button3.id -> {buclick += "3"}
            binding.button4.id -> {buclick += "4"}
            binding.button5.id -> {buclick += "5"}
            binding.button6.id -> {buclick += "6"}
            binding.button7.id -> {buclick += "7"}
            binding.button8.id -> {buclick += "8"}
            binding.button9.id -> {buclick += "9"}
            binding.button0.id -> {buclick += "0"}
        }
        binding.Expression.setText(buclick)

    }
}