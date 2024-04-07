package com.jantiojo.guidomia.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jantiojo.guidomia.data.model.Car
import kotlinx.coroutines.flow.Flow


@Dao
interface GuidomiaDao {

    @Query("select * from car")
    fun getCars() : Flow<List<Car>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCar(cars: List<Car>)

    @Query("select (select COUNT(*) from car) == 0")
    fun isEmpty(): Boolean
}