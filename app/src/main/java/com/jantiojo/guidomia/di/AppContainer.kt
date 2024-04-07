package com.jantiojo.guidomia.di

import com.jantiojo.guidomia.data.repository.CarRepository

interface AppContainer {

    val carRepository : CarRepository
}