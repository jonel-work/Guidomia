package com.jantiojo.guidomia.data.repository

import com.jantiojo.guidomia.data.local.CarLocalDataSource
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class OfflineCarRepositoryTest {

    @MockK
    private lateinit var carLocalDataSource: CarLocalDataSource


    private lateinit var offlineCarRepository: OfflineCarRepository

    @Before
    fun setup(){
        MockKAnnotations.init(this, relaxUnitFun = true)
        offlineCarRepository = OfflineCarRepository(carLocalDataSource)
    }
    @Test
    fun offlineCarRepositoryTest_getCars_verifyCarList() {
        every { carLocalDataSource.getCars() } returns FakeCarDataSource.carList
        val carList = offlineCarRepository.getCars()

        verify { carLocalDataSource.getCars() }
        assertEquals(carList, FakeCarDataSource.carList)
    }
}