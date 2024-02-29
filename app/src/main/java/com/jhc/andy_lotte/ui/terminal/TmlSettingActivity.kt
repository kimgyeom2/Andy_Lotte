package com.jhc.andy_lotte.ui.terminal

import android.os.Bundle
import androidx.activity.viewModels
import com.jhc.andy_lotte.base.BaseActivity
import com.jhc.andy_lotte.databinding.ActivityTmlSettingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TmlSettingActivity : BaseActivity() {

    val binding by lazy { ActivityTmlSettingBinding.inflate(layoutInflater) }
   // val viewModel: TmlSettingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

}