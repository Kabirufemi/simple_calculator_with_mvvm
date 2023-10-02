package com.example.learnmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.learnmvvm.databinding.ActivityMainBinding
import com.example.learnmvvm.viewmodel.CalculatorViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var calculatorViewModel: CalculatorViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        calculatorViewModel = ViewModelProvider(this).get(CalculatorViewModel::class.java)

        binding.btnCalculate.setOnClickListener {
            val num1 = binding.etNum1.text.toString().toIntOrNull() ?: 0
            val num2 = binding.etNum2.text.toString().toIntOrNull() ?: 0

            val result = calculatorViewModel.calculateSum(num1, num2)
            binding.tvResult.text = "${result.sum}"

//            binding.etNum1.text.clear()
//            binding.etNum2.text.clear()

            Toast.makeText(this, "Your answer is here", Toast.LENGTH_LONG).show()
        }
    }
}