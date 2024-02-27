package com.jhc.andy_lotte.db

import android.content.SharedPreferences

object SharedManager {
    lateinit var mPrefs: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    val USERTYPE_TERMINAL = 0
    val USERTYPE_AGENT = 1
    var userType = -1

    val PREFERENCES_NAME = "SHARED_HAND";

    // 키
    val TERMINAL_OFFICE_CODE = "TERMINAL_OFFICE_CODE";
    val TERMINAL_EMPLOYEE_CODE = "TERMINAL_EMPLOYEE_CODE";
    val TERMINAL_OFFICE_NAME = "TERMINAL_OFFICE_NAME";
    val TERMINAL_EMPLOYEE_NAME = "TERMINAL_EMPLOYEE_NAME";


    val AGENT_OFFICE_CODE = "AGENT_OFFICE_CODE";
    val AGENT_EMPLOYEE_CODE = "AGENT_EMPLOYEE_CODE";
    val AGENT_OFFICE_NAME = "AGENT_OFFICE_NAME";
    val AGENT_EMPLOYEE_NAME = "AGENT_EMPLOYEE_NAME";

    val POUCH_NUMBER = "POUCH_NUMBER";

    val SERIAL_NUMBER = "SERIAL_NUMBER";
    val UNIT_ID = "UNIT_ID";
    val BASE_DATA_DOWN = "BASE_DATA_DOWN";
    val CARINFO_DOWN = "CARINFO_DOWN";

    val PREF_SET_STORE = "PREF_SET_STORE";


    fun intialize(prefs: SharedPreferences){ mPrefs = prefs; editor = mPrefs.edit() }

    fun <T> getData(key: String, default: T): T{
        when(default){
            is Int -> return mPrefs.getInt(key,default) as T
            is String -> return mPrefs.getString(key,default) as T
            is Boolean -> return mPrefs.getBoolean(key, default) as T
            else -> return false as T
        }
    }

    fun <T> setData(key: String, value: T){
        when(value){
            is String -> {
                editor.putString(key, value)
                editor.commit() }
            is Int -> {
                editor.putInt(key, value)
                editor.commit()
            }
            is Boolean -> {
                editor.putBoolean(key, value)
                editor.commit()
            }
        }
    }

}