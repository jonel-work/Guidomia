package com.jantiojo.guidomia.data.local

import android.content.Context
import com.jantiojo.guidomia.data.model.Car
import com.jantiojo.guidomia.utils.json.JsonFileUtils

class CarLocalDataSource(private val context: Context) {

    fun getCars(): List<Car> {
        return fetchCarFromAssets()
    }


    private fun fetchCarFromAssets(): List<Car> {
        val jsonFile = JsonFileUtils.parseJsonFile(
            context,
            CAR_LIST_JSON_FILE
        )
            .getOrElse { "" }
        return JsonFileUtils.fromJsonFile<List<Car>>(jsonFile)
            .getOrElse { emptyList() }
    }

    companion object {
        private const val CAR_LIST_JSON_FILE = "car_list.json"
    }
}