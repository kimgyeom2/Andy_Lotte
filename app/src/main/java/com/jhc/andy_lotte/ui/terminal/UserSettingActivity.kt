package com.jhc.andy_lotte.ui.terminal

import android.os.Bundle
import com.jhc.andy_lotte.base.BaseActivity
import com.jhc.andy_lotte.databinding.ActivityUserSettingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserSettingActivity : BaseActivity() {

    val binding by lazy { ActivityUserSettingBinding.inflate(layoutInflater) }
   // val viewModel: TmlSettingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

}