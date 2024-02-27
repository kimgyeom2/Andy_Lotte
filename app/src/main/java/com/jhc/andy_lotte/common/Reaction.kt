package com.jhc.andy_lotte.common

import android.app.Application
import android.content.Context
import android.media.AudioAttributes
import android.media.SoundPool
import android.os.Vibrator
import com.jhc.andy_lotte.R
import com.jhc.andy_lotte.db.SharedManager

object Reaction {

    lateinit var c: Application
    val vibrator by lazy { c.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator }
    val soundPool = SoundPool.Builder().setMaxStreams(2).build()

    private val beepSuccess by lazy { soundPool.load(c, R.raw.beep_success, 1) }
    private val beepFail  by lazy { soundPool.load(c, R.raw.beep_fail, 1) }
    private val beepClick  by lazy { soundPool.load(c, R.raw.beep_click, 1) }
    private val beepOnkey  by lazy { soundPool.load(c, R.raw.onkey, 2) }
    private var vibeLength = 100L
    var isVibe = true

    fun Initialize(c: Application){
        this.c = c
        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_NOTIFICATION)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()

        isVibe = SharedManager.getData(Params.VIBE, true)
    }

    fun play_beep_fail() {
        soundPool.play(beepFail, 1f, 1f, 0, 0, 1f)
    }

    fun play_beep_success() {
        soundPool.play(beepSuccess, 1f, 1f, 0, 0, 1f)
        if (isVibe) vibrator.vibrate(vibeLength)
    }

    fun play_beep_click() {
        soundPool.play(beepClick, 1f, 1f, 0, 0, 1f)
    }

    fun play_beep_onkey() {
        soundPool.play(beepOnkey, 0.1f, 0.1f, 0, 0, 1f)
    }

    fun vibration(vibeLength: Long) {
        if(isVibe) vibrator.vibrate(vibeLength)
    }

}