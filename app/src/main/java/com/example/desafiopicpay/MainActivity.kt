package com.example.desafiopicpay

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.desafiopicpay.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        //pq na declaração desse binding é setContentView e no do Fragment é inflate? Não entendo os parametros direito


        val navController = this.findNavController(R.id.myNavHostFragment)


    }
}