package com.jhc.andy_lotte.common

import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.annotation.StringRes
import com.jhc.andy_lotte.LotteApplication

var toast: Toast? = try{ Toast.makeText(LotteApplication.appContext, "", Toast.LENGTH_SHORT) }catch(e: Exception){ null }

fun toast(@StringRes msgResId: Int, duration: Int = Toast.LENGTH_SHORT) {
    toastMakeText(msgResId, duration)
}

fun toast(msg: String, duration: Int = Toast.LENGTH_SHORT){
    toastMakeText(msg, duration)
}

private fun <T> toastMakeText(msg: T, duration: Int){
    //메인 스레드에서 호출시
    if(Looper.myLooper() == Looper.getMainLooper()){
        toast?.cancel()
        if (msg is String) toast = Toast.makeText(LotteApplication.appContext, msg, duration)
        else if (msg is Int) toast = Toast.makeText(LotteApplication.appContext, msg, duration)
        toast?.show()
    }else{
        Handler(Looper.getMainLooper()).postDelayed(
            Runnable {
                toast = Toast.makeText(LotteApplication.appContext, "", duration)
                toastMakeText(msg, duration)
            }, 0
        )
    }

}