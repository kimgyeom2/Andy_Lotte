package com.jhc.andy_lotte.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jhc.andy_lotte.db.entity.CarInfoEntity

@Dao
interface CarInfoDao {

    @Insert
    fun insert(vararg entities: CarInfoEntity)

    @Insert
    fun insertAll(entities: List<CarInfoEntity>)

    @Query("DELETE FROM carInfo")
    fun deleteAll()

    @Query("SELECT * FROM carInfo WHERE NUM == :num")
    fun getCarInfo(num: String): List<CarInfoEntity>

    @Query("SELECT * FROM carInfo WHERE NUM == :carInfoNum AND aliveCode == :scanCode")
    fun getCarInfoNum(carInfoNum: String, scanCode: String): CarInfoEntity

    @Query("SELECT * FROM carInfo WHERE NUM == :carInfoNum AND sendCode == :scanCode")
    fun getCarInfoSend(carInfoNum: String, scanCode: String): CarInfoEntity

    @Query("SELECT * FROM carInfo WHERE carCode LIKE :carCode AND aliveCode == :alive AND sendCode == :send GROUP BY carInfo.carCode")
    fun getCarInfoAliveSend(
        carCode: String,
        alive: String,
        send: String
    ): List<CarInfoEntity>

}