package com.jantiojo.guidomia.data.repository

import com.jantiojo.guidomia.data.local.CarLocalDataSource
import com.jantiojo.guidomia.data.model.Car

class OfflineCarRepository(private val localDataSource: CarLocalDataSource) : CarRepository {
    override fun getCars(): List<Car> {
        return localDataSource.getCars()
    }

    override fun getCarMakeFilterList(): List<String> {
        return localDataSource.getCarMakeFilterList()
    }

    override fun getCarModelFilterList(): List<String> {
        return localDataSource.getCarModelFilterList()
    }


}