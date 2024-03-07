package com.jhc.andy_lotte.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "car")
data class CarEntity(
    @PrimaryKey
    val num: String,
    val carCode:String?,
    val carName:String?,
    val isPay:String?
)
