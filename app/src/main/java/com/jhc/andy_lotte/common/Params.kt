package com.jhc.andy_lotte.common

object Params {
    const val AUTHORIZATION =
        "IgtAK eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJDMDEwMDY3IiwiYXVkIjoiQzAxMDA2NyIsIm5hbWUiOiJsb3R0ZWxvZ2lzcGRhIiwiZXhwIjoxNTM1MTM1NTk5OTk5LCJpYXQiOjE1NTUzOTcxMDN9.lKTmzP5tR6crc3JZLvkm1LwZ3KsaFfbYnFV69k0xOg4"
    const val KEY = "C010067"
    const val URL_API_BASE = "http://apigw.llogis.com:10110/api/pda/code/" //메이스 데이터 URL
    const val URL_DEV = "https://dev.soraj92.com:8443/AndyLotte/"
    const val URL_MAIN = "http://apigw.llogis.com:10110/api/pda/" // 데이터전송 URL
    const val URL_MAIN_DEV = "http://devapigw.llogis.com:10110/api/pda/"
    const val URL_UPDATE = "https://jhcfile.jhcon.net/file/APK/Lotte.apk"

    //    public static final String URL_UPDATE_BACKUP = "http://m.hlc.jnhsolutions.net/file/HandheldTerminal/Andy/Lotte/BackUpAPK/Lotte.apk";
    //    public static final String URL_UPDATE_CHECK = "http://m.hlc.jnhsolutions.net/file/HandheldTerminal/Andy/Lotte/Version/";
    const val APK_NAME = "Lotte.apk"

    //    public static final String URL_DEV = "http://192.168.0.136:8080/AndyLotte/";
    //    public static final String URL_DEV = "http://175.196.88.47:8080/AndyLotte/";
    //유저 타입
    const val USERTYPE_TERMINAL = 0
    const val USERTYPE_AGENT = 1
    const val USERTYPE_NOT_SELECTED = 2

    // [도착/발송] 타입
    const val ARRIVE_TYPE = 0
    const val SEND_TYPE = 1
    const val NO_DATA_INT = 0
    const val NO_DATA_STRING = ""
    const val NO_DATA_BOOLEAN = false

    //업무구분코드 workScope
    //    05:집하전, 10:집하, 11:미집하, 20:발송, 21:도착, 24:적입, 31:잔류,  40:배달전, 41:배달완료, 42:미배달
    const val WORKSCOPE = "WORKSCOPE"
    const val WORKSCOPE_PICKUP_BEFORE = "05"
    const val WORKSCOPE_PICKUP = "10"
    const val WORKSCOPE_PICKUP_NOT = "11"
    const val WORKSCOPE_SEND = "20"
    const val WORKSCOPE_ARRIVE = "21"
    const val WORKSCOPE_POUCH = "24"
    const val WORKSCOPE_STAY = "31"
    const val WORKSCOPE_DELIVERY_BEFORE = "40"
    const val WORKSCOPE_DELIVERY_COMPLELE = "41"
    const val WORKSCOPE_DELIVERY_NOT = "42"
    const val WORKSCOPE_PICKUP_BEFORE_STR = "집하전"
    const val WORKSCOPE_PICKUP_STR = "집하"
    const val WORKSCOPE_PICKUP_NOT_STR = "미집하"
    const val WORKSCOPE_SEND_STR = "발송"
    const val WORKSCOPE_ARRIVE_STR = "도착"
    const val WORKSCOPE_POUCH_STR = "적입"
    const val WORKSCOPE_STAY_STR = "잔류"
    const val WORKSCOPE_DELIVERY_BEFORE_STR = "배달전"
    const val WORKSCOPE_DELIVERY_COMPLETE_STR = "배달완료"
    const val WORKSCOPE_DELIVERY_NOT_STR = "미배달"
    val WORKSCOPE_INTS = arrayOf("", "05", "10", "11", "20", "21", "24", "31", "40", "41", "42")
    const val WORKSCOPE_PICKUP_MENU = "010"
    const val WORKSCOPE_DELIVERY_MENU = "041"
    const val WORKSCOPE_NOT_SELECTED = "N"
    const val INT_WORKSCOPE = "INT_WORKSCOPE"
    const val INT_WORKSCOPE_PICKUP_MENU = 101
    const val INT_WORKSCOPE_BEFORE_PICKUP = 5
    const val INT_WORKSCOPE_PICKUP = 10
    const val INT_WORKSCOPE_NOT_PICKUP = 11
    const val INT_WORKSCOPE_SEND = 20
    const val INT_WORKSCOPE_ARRIVE = 21
    const val INT_WORKSCOPE_POUCH = 24
    const val INT_WORKSCOPE_STAY = 31
    const val INT_WORKSCOPE_BEFORE_DELIVERY = 40
    const val INT_WORKSCOPE_DELIVERY = 41
    const val INT_WORKSCOPE_NOT_DELIVERY = 42
    const val INT_WORKSCOPE_NOT_SELECTED = -1

    //
    const val AGENT_NOT_SELECTED = "N"

    //PREFERENCES_NAME
    const val PREFERENCES_NAME = "SHARED_HAND"
    const val OFFICE_CODE = "OFFICE_CODE"
    const val PARTNER_CODE = "PARTNER_CODE"
    const val TERMINAL_OFFICE_CODE = "TERMINAL_OFFICE_CODE"
    const val TERMINAL_EMPLOYEE_CODE = "TERMINAL_EMPLOYEE_CODE"
    const val TERMINAL_OFFICE_NAME = "TERMINAL_OFFICE_NAME"
    const val TERMINAL_EMPLOYEE_NAME = "TERMINAL_EMPLOYEE_NAME"
    const val AGENT_OFFICE_CODE = "AGENT_OFFICE_CODE"
    const val AGENT_EMPLOYEE_CODE = "AGENT_EMPLOYEE_CODE"
    const val AGENT_OFFICE_NAME = "AGENT_OFFICE_NAME"
    const val AGENT_EMPLOYEE_NAME = "AGENT_EMPLOYEE_NAME"
    const val OFFICE_CODE_ALIVESEND = "40"
    const val POUCH_NUMBER = "POUCH_NUMBER"
    const val SERIAL_NUMBER = "SERIAL_NUMBER"
    const val UNIT_ID = "UNIT_ID"
    const val BASE_DATA_DOWN = "BASE_DATA_DOWN"
    const val CARINFO_DOWN = "CARINFO_DOWN"
    const val PREF_SET_STORE = "PREF_SET_STORE"

    //시스템 설정
    const val PREF_SET_AUTOBRIGHT = "PREF_SET_AUTOBRIGHT"

    //인탠트 이름
    //  메뉴 -> 액티비티
    const val INTENT_MENU = "menu"
    const val INTENT_BTN = "btn"

    //  W_Agent_Input -> W_ArriveSend_Input -> W_ArriveSend_Detail
    const val INTENT_OFFICE = "SERIAL_NUMBER"
    const val INTENT_EMPLOYEE = "SERIAL_NUMBER"

    //  W_ArriveSend_Input -> W_ArriveSend_Detail
    const val INTENT_CARINFO = "CARINFO"
    const val INTENT_PARTNER = "PARNER"
    const val INTENT_CARNUM = "CARNUM"

    //다이얼로그 모드
    const val DIALOG_OFFICE = 101
    const val DIALOG_EMPLOYEE = 102
    const val DIALOG_CAR = 103
    const val DIALOG_CARINFO = 104
    const val DIALOG_SAU = 105
    const val DIALOG_TIME = 106
    const val DIALOG_DATE = 107
    const val DIALOG_ZIP = 108

    //집하종류
    const val PICKUP_AMOUNT = "PICKUP_AMOUNT"
    const val PICKUP_TYPE = "PICKUP_TYPE"
    const val PICKUP_TYPE_CODE = "PICKUP_TYPE_CODE"
    const val PICKUP_SOLUTION = "PICKUP_SOLUTION"
    const val PICKUP_BOX_TYPE = "PICKUP_BOX_TYPE"
    const val PICKUP_BOX_TYPE_CODE = "PICKUP_BOX_TYPE_CODE"
    const val PICKUP_PAYMENT = "PICKUP_PAYMENT"
    const val PICKUP_PRICE = "PICKUP_PRICE"
    const val PICKUP_AMOUNT_NORMAL = "일반집하"
    const val PICKUP_AMOUNT_LARGE = "대량"
    const val PICKUP_TYPE_NORMAL = "일반"
    const val PICKUP_TYPE_WEAR = "의류"
    const val PICKUP_TYPE_NORMAL_CODE = "00"
    const val PICKUP_TYPE_WEAR_CODE = "01"
    const val PICKUP_PAYMENT_CASH = "현불"
    const val PICKUP_PAYMENT_NO_CASH = "현불외"
    const val PICKUP_PAYMENT_CASH_CODE = "01"
    const val DELIVERY_PAYMENT = "DELIVERY_PAYMENT"
    const val DELIVERY_PRICE = "DELIVERY_PRICE"
    const val DELIVERY_PAYMENT_CASH = "착불"
    const val DELIVERY_PAYMENT_NO_CASH = "착불외"
    const val DELIVERY_PAYMENT_CASH_CODE = "02"

    //
    const val STR_TRUE = "Y"
    const val STR_FALSE = "N"

    //file
    const val FILE_PATH_1 = "/Pair"
    const val FILE_PATH_2 = "/Pair/Andy"
    const val FILE_PATH_3 = "/Data"
    const val FILE_PATH_ALL = "/Pair/Andy/Data"
    const val FILE_NAME = "/pair.txt"
    const val SEND_MODE = "SEND_MODE"
    const val SEND_MODE_OUTSIDE = 0
    const val SEND_MODE_INSIDE = 1

    //다이얼 로그
    const val DIALOG_CAR_INFO = "1"
    const val DIALOG_SEND_DATA = "2"
    const val DIALOG_BASE_DATA = "3"
    const val DIALOG_CHECK_UPDATE = "4"
    const val DIALOG_UPDATE = "5"

    //시스템 설정
    const val VIBE = "VIBE"
    const val VIBE_LENGTH = "VIBE_LENGTH"
    const val SHIELD = "SHIELD"
    const val VIBE_LENGTH_10 = 100
    const val VIBE_LENGTH_20 = 200
    const val VIBE_LENGTH_30 = 300
    const val VIBE_LENGTH_05 = 100
    const val VIBE_LENGTH_01 = 100
    const val INT_VIBE_LENGTH = 150
    const val INTERVAL_SET = "INTERVAL_SET"
    const val INTERVAL_SET_10 = 100
    const val INTERVAL_SET_20 = 200
    const val INTERVAL_SET_30 = 300
    const val INTERVAL_SET_05 = 50
    const val INTERVAL_SET_01 = 10
    const val SCAN_TIMEOUT = "SCAN_TIMEOUT"

    //개발자 설정
    const val DEV_SEND_URL = "1"
}