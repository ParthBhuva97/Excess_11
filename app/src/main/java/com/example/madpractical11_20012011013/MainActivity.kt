package com.example.madpractical11_20012011013

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.madpractical11_20012011013.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}