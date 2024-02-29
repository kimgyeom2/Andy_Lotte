package com.jhc.andy_lotte.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "office")
data class OfficeEntity(
    @PrimaryKey
    var num: String ,
    var code: String,
    var officeName: String
)
