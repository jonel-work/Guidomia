package com.jantiojo.guidomia.data.local

import android.content.Context
import com.jantiojo.guidomia.data.model.Car

class CarLocalDataSource(private val context: Context) {

    fun getCars(): List<Car> {
        return emptyList()
    }
}