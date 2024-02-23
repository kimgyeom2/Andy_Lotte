package com.jhc.andy_lotte.api

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Build
import android.os.Environment
import androidx.core.content.FileProvider
import com.jhc.andy_lotte.common.toast
import java.io.File

class UpdateManager(private val context: Context) {

    companion object {
        private const val APK_NAME = "andy_lotte.apk"
        private const val BASE_PATH = "file://"
        private const val DOWNLOAD_URL =
            "https://jhcfile.jhcon.net/file/APK/andy_lotte_test.apk"
        private const val MIME_TYPE = "application/vnd.android.package-archive"
        private const val PROVIDER_PATH = ".provider"
        private const val APP_INSTALL_PATH = "application/vnd.android.package-archive"
    }

    fun update() {
        // APK Download setting
        val dest =
            context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).toString() + "/" + APK_NAME
        val destFile = File(dest)

        // Delete APK if it already exists.
        if (destFile.exists()) destFile.delete()

        // Request download
        val baseUri = Uri.parse(BASE_PATH + dest)
        val downloadUri = Uri.parse(DOWNLOAD_URL)
        val downloadReq = DownloadManager.Request(downloadUri)

        downloadReq.setMimeType(MIME_TYPE)
        downloadReq.setDescription("잠시만 기다려주세요.")

        // Set destination
        downloadReq.setDestinationUri(baseUri)

        showInstallOption(dest, baseUri)

        // Download enqueue
        val downloadManager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        downloadManager.enqueue(downloadReq)

        toast("잠시만 기다려주세요.")

    }

    private fun showInstallOption(dest: String, uri: Uri) {
        // Set Broadcast receiver to install app when APK is downloaded.
        val completeReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent?) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    val contentUri = FileProvider.getUriForFile(
                        context,
                        context.packageName + PROVIDER_PATH,
                        File(dest)
                    )
                    val installIntent = Intent(Intent.ACTION_VIEW).apply {
                        addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        putExtra(Intent.EXTRA_NOT_UNKNOWN_SOURCE, true)
                        data = contentUri
                    }

                    context.startActivity(installIntent)
                    context.unregisterReceiver(this)
                } else {
                    val installIntent = Intent(Intent.ACTION_VIEW).apply {
                        flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        setDataAndType(uri, APP_INSTALL_PATH)
                    }

                    context.startActivity(installIntent)
                    context.unregisterReceiver(this)
                }
            }
        }

        context.registerReceiver(
            completeReceiver,
            IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE)
        )
    }
}