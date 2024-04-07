package com.jantiojo.guidomia.data.repository

import com.jantiojo.guidomia.data.local.CarLocalDataSource
import com.jantiojo.guidomia.data.model.Car
import kotlinx.coroutines.flow.Flow

class OfflineCarRepository(private val localDataSource: CarLocalDataSource) : CarRepository {
    override suspend fun getCars(): Flow<List<Car>> {
        return localDataSource.getCars()
    }

    override suspend fun getCarMakeFilterList(): Flow<List<String>> {
        return localDataSource.getCarMakeFilterList()
    }

    override suspend fun getCarModelFilterList(): Flow<List<String>> {
        return localDataSource.getCarModelFilterList()
    }

}