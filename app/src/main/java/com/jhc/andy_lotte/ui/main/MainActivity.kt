package com.jhc.andy_lotte.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import com.jhc.andy_lotte.common.KeyTrans
import com.jhc.andy_lotte.common.Version
import com.jhc.andy_lotte.common.toast
import com.jhc.andy_lotte.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    val version=Version()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.apply {
            val v="ver "+this@MainActivity.version.getDevVersion()
            version.text=v
        }.root)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        val button = when (KeyTrans.keyTrans(keyCode, event)) {
            KeyEvent.KEYCODE_1 -> binding.btnTerminal
            KeyEvent.KEYCODE_2 -> binding.btnAgency
            KeyEvent.KEYCODE_3 -> binding.btnData
            KeyEvent.KEYCODE_4 -> binding.btnSetting
            KeyEvent.KEYCODE_BACK -> {
                onBackPressed()
                return true
            }
            else -> return false
        }
        button.requestFocus()
        button.performClick()
        return true
    }

    private var backPressedTime = 0L
    override fun onBackPressed() {
        val waitTime = 2000L
        val systemTime = System.currentTimeMillis()

        if (systemTime > backPressedTime + waitTime) {
            backPressedTime = systemTime
            toast("뒤로가기 버튼을 한 번 더 누르시면 앱이 종료됩니다.")
        } else {
            finish()
        }
    }
}