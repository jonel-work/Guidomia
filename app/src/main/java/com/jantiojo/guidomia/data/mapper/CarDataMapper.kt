package com.jantiojo.guidomia.data.mapper

import com.jantiojo.guidomia.data.model.Car
import com.jantiojo.guidomia.ui.model.CarItemUiModel
import com.jantiojo.guidomia.utils.CarUtils

fun Car.toCarUiModel() = CarItemUiModel(
    cons = this.consList,
    name = "${this.make} ${this.model}",
    image = CarUtils.getCarMakeImageResource(this.make),
    priceDisplay = "120k",//TODO create utils or extension for customerPrice display
    pros = this.prosList,
    rating = this.rating,
)

fun List<Car>.toCarUiModelList() = map { it.toCarUiModel() }