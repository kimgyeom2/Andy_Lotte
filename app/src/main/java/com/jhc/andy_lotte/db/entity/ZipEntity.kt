package com.jhc.andy_lotte.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "zip")
data class ZipEntity(
    @PrimaryKey
    var idx: Int,
    var code: Int,
    var zipName: String,
)
