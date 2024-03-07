package com.jhc.andy_lotte.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sau")
data class SauEntity(
    @PrimaryKey
    val code: Int,
    val sauName: String?
)
