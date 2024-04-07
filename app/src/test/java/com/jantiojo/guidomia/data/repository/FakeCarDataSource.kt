package com.jantiojo.guidomia.data.repository

import com.jantiojo.guidomia.data.model.Car

object FakeCarDataSource {

    val carList = listOf(
        Car(
            consList = listOf("Bad"),
            customerPrice = 120000,
            make = "CarMaker1",
            marketPrice = 125000,
            model = "CarModel1",
            prosList = listOf(
                "Smooth",
                "Faster"
            ),
            rating = 1
        ),
        Car(
            consList = listOf("Very Bad"),
            customerPrice = 120000,
            make = "CarMaker2",
            marketPrice = 125000,
            model = "CarModel2",
            prosList = listOf("Super Faster"),
            rating = 1
        ),
    )
}