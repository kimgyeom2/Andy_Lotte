package com.jhc.andy_lotte.db.dao

import androidx.room.Dao
import androidx.room.Insert
import com.jhc.andy_lotte.db.entity.OfficeEntity

@Dao
interface OfficeDao {
    @Insert
    fun insert(officeEntities: OfficeEntity)

}