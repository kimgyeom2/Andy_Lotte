package com.jhc.andy_lotte

import android.app.Application
import android.content.Context
import com.jhc.andy_lotte.common.Params
import com.jhc.andy_lotte.common.Reaction
import com.jhc.andy_lotte.db.SharedManager
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class LotteApplication:Application() {

    companion object {
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this
        SharedManager.intialize(getSharedPreferences(Params.PREFERENCES_NAME, Context.MODE_PRIVATE))
        Reaction.Initialize(this)
    }

}