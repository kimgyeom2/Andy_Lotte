package com.jhc.andy_lotte.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jhc.andy_lotte.db.entity.EmployeeEntity

@Dao
interface EmployeeDao {
    @Insert
    fun insert(entities: EmployeeEntity)

    @Insert
    fun insertAll(entities: List<EmployeeEntity>)

    @Query("SELECT * FROM employee WHERE office == :officeNum")
    fun getEmployeeList(officeNum: String): LiveData<List<EmployeeEntity>>

    @Query("SELECT * FROM employee WHERE office == :officeNum AND num LIKE :empNum")
    fun getEmployeeList_OfficeCode(officeNum: String, empNum: String): List<EmployeeEntity>

    @Query("SELECT * FROM employee")
    fun getEmployeeList(): List<EmployeeEntity>

    @Query("DELETE FROM employee")
    fun deleteAll()
}