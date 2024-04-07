package com.jantiojo.guidomia

import android.app.Application
import com.jantiojo.guidomia.di.AppContainer
import com.jantiojo.guidomia.di.AppDataContainer

class GuidomiaApplication : Application() {

    private lateinit var appContainer: AppContainer
    override fun onCreate() {
        super.onCreate()
        appContainer = AppDataContainer(this)
    }
}