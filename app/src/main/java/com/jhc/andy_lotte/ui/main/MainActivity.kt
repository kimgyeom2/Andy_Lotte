package com.jhc.andy_lotte.ui.main

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import com.jhc.andy_lotte.R
import com.jhc.andy_lotte.base.BaseActivity
import com.jhc.andy_lotte.common.KeyTrans
import com.jhc.andy_lotte.common.Version
import com.jhc.andy_lotte.common.toast
import com.jhc.andy_lotte.databinding.ActivityMainBinding
import com.jhc.andy_lotte.db.AppDataBase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    @Inject
    lateinit var database: AppDataBase
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    val viewModel: MainViewModel by viewModels()
    val version=Version()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.onBackPressedDispatcher.addCallback(this, callback)
        setContentView(binding.apply {
            viewModel=this@MainActivity.viewModel
        }.root)
        CoroutineScope(Dispatchers.IO).launch {
            database.zipDao().getAll()
        }
    }

    override fun onResume() {
        super.onResume()
        binding.btnTerminal.isFocusable=true
    }
    fun onClick(view: View) {
       Log.i("gyeom",view.id.toString())
    }
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        val button = when (KeyTrans.keyTrans(keyCode, event)) {
            KeyEvent.KEYCODE_1 -> binding.btnTerminal
            KeyEvent.KEYCODE_2 -> binding.btnAgency
            KeyEvent.KEYCODE_3 -> binding.btnData
            KeyEvent.KEYCODE_4 -> binding.btnSetting
            KeyEvent.KEYCODE_BACK -> {
                callback.handleOnBackPressed()
                return true
            }
            else -> return false
        }
        button.requestFocus()
        button.performClick()
        return true
    }

    private var backPressedTime = 0L

    private val callback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            val waitTime = 2000L
            val systemTime = System.currentTimeMillis()

            if (systemTime > backPressedTime + waitTime) {
                backPressedTime = systemTime
                toast(R.string.back_press)
            } else {
                finish()
            }
        }
    }

}