package com.jhc.andy_lotte.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "service")
data class ServiceEntity(
    @PrimaryKey
    val idx: Int,
    val code: String?,
    val serviceName: String?
)
