package com.jhc.andy_lotte.ui.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jhc.andy_lotte.R
import com.jhc.andy_lotte.base.BaseViewModel
import com.jhc.andy_lotte.common.Utils
import com.jhc.andy_lotte.common.Version
import com.jhc.andy_lotte.common.toast
import com.jhc.andy_lotte.usecase.AdminUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val adminUseCase: AdminUseCase) : BaseViewModel() {

    val version by lazy { Version() }
    val updateNeeded = MutableStateFlow(false)
    val goMain = MutableStateFlow(false)

    fun getVersion() {
        viewModelScope.launch {
            try {
                adminUseCase.getVersion().collect {
                    if (version.versionToInt(it.app_ver) > version.versionToInt(version.getDevVersion())) {
                        updateNeeded.value = true
                    } else {
                        toast(R.string.newest_version)
                        goMain.value = true
                        withContext(Dispatchers.IO){
                            adminUseCase.db()
                        }
                    }
                }
            } catch (e: Exception) {
                errorHandling(e)
            }
        }
    }

}
