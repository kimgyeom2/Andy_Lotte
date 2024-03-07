package com.jhc.andy_lotte.db.dao

import androidx.room.Dao
import androidx.room.Insert
import com.jhc.andy_lotte.db.entity.CarInfoEntity

@Dao
interface CarInfoDao {

    @Insert
    fun insert(vararg entities: CarInfoEntity)


}