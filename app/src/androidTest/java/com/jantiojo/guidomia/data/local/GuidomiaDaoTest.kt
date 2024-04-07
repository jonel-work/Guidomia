package com.jantiojo.guidomia.data.local

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GuidomiaDaoTest {

    @get:Rule
    val dispatcherRule = TestDispatcherRule()

    private lateinit var guidomiaDao: GuidomiaDao

    private lateinit var guidomiaAppDataBase: GuidomiaAppDataBase

    @Before
    fun setup() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext

        guidomiaAppDataBase =
            Room.inMemoryDatabaseBuilder(appContext, GuidomiaAppDataBase::class.java)
                .allowMainThreadQueries()
                .build()

        guidomiaDao = guidomiaAppDataBase.guidomiaDao()
    }

    @After
    fun tearDown() {
        guidomiaAppDataBase.close()
    }

    @Test
    fun guidomiaDao_insertCars_insertSuccess() = runTest {
        addAllCars()
        val cars = guidomiaDao.getCars().first()
        assertEquals(cars, FakeCarDataSource.carList)
    }

    @Test
    fun guidomiaDao_getCars_returnAllCarsFromDB() = runTest {
        val fakeCars =  FakeCarDataSource.carList
        addAllCars()
        val favorites = guidomiaDao.getCars().first()
        assertEquals(fakeCars.first(), favorites.first())
        assertEquals(fakeCars[1], favorites[1])
    }

    @Test
    fun guidomiaDao_isEmpty_returnFalse() = runTest {
        addAllCars()
        val cars = guidomiaDao.getCars().first()
        val isEmptyDB = guidomiaDao.isEmpty()
        assertEquals(cars.isNotEmpty(), true)
        assertEquals(isEmptyDB.not(), true)
    }

    private suspend fun addAllCars() {
        guidomiaDao.insertAllCar(FakeCarDataSource.carList)
    }
}