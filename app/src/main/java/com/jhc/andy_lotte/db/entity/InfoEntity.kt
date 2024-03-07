package com.jhc.andy_lotte.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "infodata")
data class InfoEntity(
    @PrimaryKey(autoGenerate = true)
    val idx:Int,
    val workScope:String,
    val workDate:String,
    val workTime:String,
    val workDateStamp: Long,
    val employeeCode:String,
    val carCode :String,
    val officeCode :String,
    val partnerCode :String,
    val serviceCode :String,
    val aliveCode:String,
    val many :String,
    val equipment :String,
    val trackingNumber :String,
    val trackingNumberAssist:String,  //  연계일보번호 (도착/발송)
    val sauCode :String,
    val serialNumber:String,
    val send:String
)