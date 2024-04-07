package com.jantiojo.guidomia.data.repository

import com.jantiojo.guidomia.data.model.Car
import kotlinx.coroutines.flow.Flow

interface CarRepository {

    /**
     *  Fetches Car from Assets
     */
    suspend fun getCars(): Flow<List<Car>>


    suspend fun getCarMakeFilterList(): Flow<List<String>>

    suspend fun getCarModelFilterList(): Flow<List<String>>
}