package com.jantiojo.guidomia.di

import android.content.Context
import com.jantiojo.guidomia.data.local.CarLocalDataSource
import com.jantiojo.guidomia.data.local.GuidomiaAppDataBase
import com.jantiojo.guidomia.data.repository.CarRepository
import com.jantiojo.guidomia.data.repository.OfflineCarRepository

class AppDataContainer(private val context: Context) : AppContainer {
    override val carRepository: CarRepository by lazy {
        OfflineCarRepository(
            CarLocalDataSource(
                context,
                GuidomiaAppDataBase.getDatabase(context).guidomiaDao()
            )
        )
    }
}