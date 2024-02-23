package com.jhc.andy_lotte.common

import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AlertDialog
import com.jhc.andy_lotte.LotteApplication
import com.jhc.andy_lotte.api.UpdateManager

class Version(private val context: Context = LotteApplication.appContext) {

    fun showUpdateDialog() {
        val builder = AlertDialog.Builder(context).apply {
            setTitle("업데이트 확인")
            //setIcon(R.drawable.logo)
            setMessage("앱을 사용하시려면 업데이트를 해야 합니다.")
            setCancelable(false)
            setPositiveButton("예") { _, _ ->
                UpdateManager(context).update()
            }
        }
        builder.show()
    }

    fun getDevVersion(): String {
        return try {
            context.packageManager.getPackageInfo(context.packageName, 0)
        } catch (e: PackageManager.NameNotFoundException) {
            null
        }?.versionName ?: "UNKNOWN"
    }

    fun versionToInt(version: String): Int{
        return if(version != "UNKNOWN") version.replace("[^0-9]".toRegex(), "").toInt() else 0
    }
}
