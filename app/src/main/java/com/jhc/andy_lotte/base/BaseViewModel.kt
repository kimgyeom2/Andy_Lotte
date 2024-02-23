package com.jhc.andy_lotte.base

import androidx.lifecycle.ViewModel
import com.jhc.andy_lotte.R
import com.jhc.andy_lotte.common.toast
import java.net.UnknownHostException

open class BaseViewModel:ViewModel() {

    fun errorHandling(error: Throwable) {

        if (error is UnknownHostException) {
            toast(R.string.err_internet_connection)
            return
        }

        when(error.message){
            else -> (error.message ?: "null 오류")
        }.let {
            toast(it)
        }
    }

}