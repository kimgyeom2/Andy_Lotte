package com.jhc.andy_lotte.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jhc.andy_lotte.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.apply {

        }.root)
    }
}