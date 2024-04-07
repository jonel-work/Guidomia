package com.jantiojo.guidomia.data.local

import android.content.Context
import com.jantiojo.guidomia.R
import com.jantiojo.guidomia.data.model.Car
import com.jantiojo.guidomia.utils.json.JsonFileUtils
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf

class CarLocalDataSource(
    private val context: Context,
    private val guidomiaDao: GuidomiaDao
) {

    suspend fun getCars(): Flow<List<Car>> {
        val carsFromAsset = fetchCarFromAssets()
        return if (!guidomiaDao.isEmpty()) {
            guidomiaDao.getCars()
        } else {
            guidomiaDao.insertAllCar(carsFromAsset)
            flowOf(carsFromAsset)
        }
    }

    suspend fun getCarMakeFilterList(): Flow<List<String>> {
        val dropdownFilterList = mutableListOf<String>()
        dropdownFilterList.add(context.resources.getString(R.string.any_make_hint))
        dropdownFilterList.addAll(getCars().first().map { it.make })
        return flowOf(dropdownFilterList)
    }

    suspend fun getCarModelFilterList(): Flow<List<String>> {
        val dropdownFilterList = mutableListOf<String>()
        dropdownFilterList.add(context.resources.getString(R.string.any_model_hint))
        dropdownFilterList.addAll(getCars().first().map { it.model })
        return flowOf(dropdownFilterList)
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