package com.jhc.andy_lotte.common

import android.view.KeyEvent

object KeyTrans {

    var model = android.os.Build.MODEL
    val modelA124 = "iData18"
    val modelA2 = "A65"
    val modelA128 = "m52"
    val modelA132 = "i3"
    val modelDT30 = "DT30"
    val modelSQ38 = "SQ38"

    val scanKeyLeft = 1000
    val scanKeyCenter = 1001
    val scanKeyRight = 1002
    val scanKeyTrigger = 1003
    val scanKeys = arrayOf(scanKeyLeft, scanKeyCenter, scanKeyRight, scanKeyTrigger)

    /**
     *  키변환
     *  대소문자, 펑션키 -> INT (키코드 EX 0: 7)
     */

    fun keyTrans(key: Int, event: KeyEvent? = null): Int{
        when(key){
            in KeyEvent.KEYCODE_0.n()..KeyEvent.KEYCODE_9 -> return key
            in KeyEvent.KEYCODE_A.n()..KeyEvent.KEYCODE_O -> return (key-2) / 3
            in KeyEvent.KEYCODE_P.n()..KeyEvent.KEYCODE_S -> return KeyEvent.KEYCODE_7
            in KeyEvent.KEYCODE_T.n()..KeyEvent.KEYCODE_V -> return KeyEvent.KEYCODE_8
            in KeyEvent.KEYCODE_W.n()..KeyEvent.KEYCODE_Z -> return KeyEvent.KEYCODE_9
            else -> {
                when(model){
                    modelA124 -> {
                        when(key){
                            KeyEvent.KEYCODE_STAR, KeyEvent.KEYCODE_PERIOD -> return KeyEvent.KEYCODE_1
                            KeyEvent.KEYCODE_POUND, KeyEvent.KEYCODE_MINUS -> return KeyEvent.KEYCODE_0
                            KeyEvent.KEYCODE_BUTTON_2 -> return scanKeyLeft
                            KeyEvent.KEYCODE_BUTTON_3 -> return scanKeyCenter
                            KeyEvent.KEYCODE_BUTTON_1 -> return scanKeyRight
                        }
                    }
                    modelA128 -> {
                        when(key) {
                            KeyEvent.KEYCODE_STAR, KeyEvent.KEYCODE_MINUS -> return KeyEvent.KEYCODE_1
                            KeyEvent.KEYCODE_PERIOD, KeyEvent.KEYCODE_POUND -> return KeyEvent.KEYCODE_0
                            293 -> {
                                event?.apply {
                                    when (scanCode) {
                                        310 -> return scanKeyLeft
                                        317 -> return scanKeyCenter
                                        311 -> return scanKeyRight
                                    }
                                }
                            }
                            in KeyEvent.KEYCODE_F1.n()..KeyEvent.KEYCODE_F9 -> return key - 123
                            KeyEvent.KEYCODE_F10 -> return key - 133
                        }
                    }
                    modelA132 -> {
                        when(key){
                            KeyEvent.KEYCODE_AT, KeyEvent.KEYCODE_SEMICOLON, KeyEvent.KEYCODE_SLASH -> return KeyEvent.KEYCODE_1
                            KeyEvent.KEYCODE_SPACE -> return KeyEvent.KEYCODE_0
                            KeyEvent.KEYCODE_BUTTON_2 -> return scanKeyLeft
                            KeyEvent.KEYCODE_BUTTON_1 -> return scanKeyCenter
                            KeyEvent.KEYCODE_BUTTON_3 -> return scanKeyRight
                            in KeyEvent.KEYCODE_F1.n()..KeyEvent.KEYCODE_F9 -> return key - 123
                            KeyEvent.KEYCODE_F10 -> return key - 133
                        }
                    }
                    modelA2 -> {
                        when(key){
                            KeyEvent.KEYCODE_AT, KeyEvent.KEYCODE_SLASH, KeyEvent.KEYCODE_PLUS -> return KeyEvent.KEYCODE_1
                            KeyEvent.KEYCODE_SPACE -> return KeyEvent.KEYCODE_0
                            KeyEvent.KEYCODE_F9 -> return scanKeyLeft
                            KeyEvent.KEYCODE_F10 -> return scanKeyCenter
                            KeyEvent.KEYCODE_F8 -> return scanKeyRight
                            KeyEvent.KEYCODE_F11 -> return scanKeyTrigger
                            in KeyEvent.KEYCODE_F1.n()..KeyEvent.KEYCODE_F7 -> return key - 123
                        }
                    }
                    modelDT30, modelSQ38 -> {
                        return when(key){
                            520 -> scanKeyLeft
                            522 -> scanKeyCenter
                            521 -> scanKeyRight
                            0 -> KeyEvent.KEYCODE_1
                            KeyEvent.KEYCODE_SPACE -> KeyEvent.KEYCODE_0
                            else -> key
                        }
                    }
                }
            }
        }
        return key
    }

}