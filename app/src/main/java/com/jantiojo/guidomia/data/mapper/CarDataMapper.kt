package com.jantiojo.guidomia.data.mapper

import com.jantiojo.guidomia.data.model.Car
import com.jantiojo.guidomia.ui.model.CarItemUiModel
import com.jantiojo.guidomia.utils.CarUtils

fun Car.toCarUiModel() = CarItemUiModel(
    cons = this.consList.filterNot { it.isBlank() },
    name = "${this.make} ${this.model}",
    image = CarUtils.getCarMakeImageResource(this.make),
    priceDisplay = CarUtils.priceCompactShortFormat(this.customerPrice),
    pros = this.prosList.filterNot { it.isBlank() },
    rating = this.rating,
)

fun List<Car>.toCarUiModelList() = map { it.toCarUiModel() }