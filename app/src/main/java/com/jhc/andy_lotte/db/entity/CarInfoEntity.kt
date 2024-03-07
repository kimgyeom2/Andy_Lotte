package com.jhc.andy_lotte.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "carInfo")
data class CarInfoEntity(
    @PrimaryKey(autoGenerate = true)
    val idx :Int,
    val standardDate: String?,
    val num: String?,
    val sendCode: String?,
    val aliveCode: String?,
    val carCode: String?,
    val carNum: String?,
    val carNumFull: String?
):Serializable
