package com.jhc.andy_lotte

import android.app.Application
import android.content.Context
import com.jhc.andy_lotte.common.Params
import com.jhc.andy_lotte.common.Reaction
import com.jhc.andy_lotte.db.AppDataBase
import com.jhc.andy_lotte.db.SharedManager
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class LotteApplication:Application() {

    @Inject
    lateinit var database: AppDataBase
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