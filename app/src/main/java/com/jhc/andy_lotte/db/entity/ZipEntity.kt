package com.jhc.andy_lotte.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "zip")
data class ZipEntity(
    @PrimaryKey
    val idx: Int,
    val code: Int,
    val zipName: String?,
)
