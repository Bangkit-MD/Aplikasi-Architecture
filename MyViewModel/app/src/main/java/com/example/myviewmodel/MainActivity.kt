package com.example.myviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.activity.viewModels
import com.example.myviewmodel.databinding.ActivityMainBinding

//import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//    private lateinit var viewModel: MainViewModel
    private val viewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        displayResult()

        binding.btnCalculate.setOnClickListener {
            val width = binding.edtWidth.text.toString()
            val height = binding.edtHeight.text.toString()
            val length = binding.edtLength.text.toString()

            when{
                width.isEmpty() -> binding.edtWidth.error = "Masih Kosong"
                height.isEmpty() -> binding.edtWidth.error = "Masih Kosong"
                length.isEmpty() -> binding.edtWidth.error = "Masih Kosong"
                else ->{
                    viewModel.calculate(width,height,length)
                    displayResult()
                }
            }
        }

    }
    private fun displayResult(){
        binding.tvResult.text = viewModel.result.toString()
    }
}