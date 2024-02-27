package com.jhc.andy_lotte.ui.splash

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import com.jhc.andy_lotte.MainActivity
import com.jhc.andy_lotte.R
import com.jhc.andy_lotte.api.UpdateManager
import com.jhc.andy_lotte.common.Version
import com.jhc.andy_lotte.common.toast
import com.jhc.andy_lotte.databinding.ActivitySplashBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    val binding by lazy { ActivitySplashBinding.inflate(layoutInflater) }
    val viewModel:SplashViewModel by viewModels()
    val version = Version(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        versionCheck()
        observeUpdate()
        observeGoMain()
    }


    // 업데이트 관련 함수 start ~

    val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            version.showUpdateDialog()
        } else {
            toast(R.string.update_permission_denied_msg)
        }
    }

    private fun versionCheck(){
        viewModel.getVersion()
    }

    private fun observeGoMain(){
        lifecycleScope.launchWhenCreated {
            viewModel.goMain.collect{
                if (it){
                    delay(2000)
                    startActivity(Intent(this@SplashActivity,MainActivity::class.java))
                    finish()
                }
            }
        }
    }

    private fun observeUpdate(){
        lifecycleScope.launchWhenCreated {
            viewModel.updateNeeded.collect { needUpdate ->
                if (needUpdate) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && !packageManager.canRequestPackageInstalls()) {
                        requestPermission()
                    }else{
                        version.showUpdateDialog()
                    }
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun requestPermission() {
        try {
            launcher.launch(
                Intent(
                    Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES,
                    Uri.parse("package:${packageName}")
                )
            )
        } catch (e: Exception) {
            version.showUpdateDialog()
        }
    }
    // 업데이트 관련 함수 end ~
}