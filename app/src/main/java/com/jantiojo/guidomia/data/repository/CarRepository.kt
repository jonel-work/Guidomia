package com.jantiojo.guidomia.data.repository

import com.jantiojo.guidomia.data.model.Car

interface CarRepository {

    /**
     *  Fetches Car from Assets
     */
    fun getCars(): List<Car>


    fun getCarMakeFilterList(): List<String>

    fun getCarModelFilterList(): List<String>
}