package com.jantiojo.guidomia.data.repository

import app.cash.turbine.test
import com.jantiojo.guidomia.data.TestDispatcherRule
import com.jantiojo.guidomia.data.local.CarLocalDataSource
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class OfflineCarRepositoryTest {

    @get:Rule
    val dispatcherRule = TestDispatcherRule()

    @MockK
    private lateinit var carLocalDataSource: CarLocalDataSource

    private lateinit var offlineCarRepository: OfflineCarRepository

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        offlineCarRepository = OfflineCarRepository(carLocalDataSource)
    }

    @Test
    fun offlineCarRepositoryTest_getCars_verifyCarList() = runTest {
        coEvery { carLocalDataSource.getCars() } returns flowOf(FakeCarDataSource.carList)
        val carList = offlineCarRepository.getCars()

        coVerify { carLocalDataSource.getCars() }

        carList.test {
            val item = awaitItem()
            assertEquals(item, FakeCarDataSource.carList)
            awaitComplete()
        }
    }

    @Test
    fun offlineCarRepositoryTest_getCarMakeFilterList_verifyCarMakeList() = runTest {
        val dropdownList = FakeCarDataSource.carList.map { it.make }
        coEvery { carLocalDataSource.getCarMakeFilterList() } returns flowOf(dropdownList)
        val carMakeFilterList = offlineCarRepository.getCarMakeFilterList()

        coVerify { carLocalDataSource.getCarMakeFilterList() }
        carMakeFilterList.test {
            val item = awaitItem()
            assertEquals(item, dropdownList)
            awaitComplete()
        }
    }

    @Test
    fun offlineCarRepositoryTest_getCarModelFilterList_verifyCarModelList() = runTest {
        val dropdownList = FakeCarDataSource.carList.map { it.model }
        coEvery { carLocalDataSource.getCarModelFilterList() } returns flowOf(dropdownList)
        val carModelFilterList = offlineCarRepository.getCarModelFilterList()

        coVerify { carLocalDataSource.getCarModelFilterList() }
        carModelFilterList.test {
            val item = awaitItem()
            assertEquals(item, dropdownList)
            awaitComplete()
        }
    }
}