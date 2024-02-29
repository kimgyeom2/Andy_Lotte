package com.jhc.andy_lotte.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jhc.andy_lotte.db.dao.CarInfoDao
import com.jhc.andy_lotte.db.dao.EmployeeDao
import com.jhc.andy_lotte.db.dao.InfoDao
import com.jhc.andy_lotte.db.dao.OfficeDao
import com.jhc.andy_lotte.db.dao.SauDao
import com.jhc.andy_lotte.db.dao.ServiceDao
import com.jhc.andy_lotte.db.dao.ZipDao
import com.jhc.andy_lotte.db.entity.CarInfoEntity
import com.jhc.andy_lotte.db.entity.EmployeeEntity
import com.jhc.andy_lotte.db.entity.InfoEntity
import com.jhc.andy_lotte.db.entity.OfficeEntity
import com.jhc.andy_lotte.db.entity.SauEntity
import com.jhc.andy_lotte.db.entity.ServiceEntity
import com.jhc.andy_lotte.db.entity.ZipEntity

@Database(
    entities = [
        CarInfoEntity::class,
        EmployeeEntity::class,
        InfoEntity::class,
        OfficeEntity::class,
        SauEntity::class,
        ServiceEntity::class,
        ZipEntity::class
    ], version = 1, exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {

    abstract fun carInfoDao(): CarInfoDao
    abstract fun employeeDao(): EmployeeDao
    abstract fun infoDao(): InfoDao
    abstract fun officeDao(): OfficeDao
    abstract fun sauDao(): SauDao
    abstract fun serviceDao(): ServiceDao
    abstract fun zipDao(): ZipDao

}
