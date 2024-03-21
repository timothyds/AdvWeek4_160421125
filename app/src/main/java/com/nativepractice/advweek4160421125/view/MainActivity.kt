package com.nativepractice.advweek4160421125.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nativepractice.advweek4160421125.R
import com.nativepractice.advweek4160421125.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}