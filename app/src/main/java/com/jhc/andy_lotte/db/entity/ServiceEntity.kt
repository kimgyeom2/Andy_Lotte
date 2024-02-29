package com.jhc.andy_lotte.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "service")
data class ServiceEntity(
    @PrimaryKey
    var idx: Int,
    var code: String,
    var serviceName: String
)
