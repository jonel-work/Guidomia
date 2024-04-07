package com.jantiojo.guidomia.ui.car

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.jantiojo.guidomia.ui.model.CarImageResource
import com.jantiojo.guidomia.ui.model.CarItemUiModel

class CarItemPreviewProvider : PreviewParameterProvider<CarItemUiModel> {
    override val values: Sequence<CarItemUiModel>
        get() = sequenceOf(
            CarItemUiModel(
                name = "BMW 330i",
                image = CarImageResource.BMW,
                priceDisplay = "55k" ,
                cons = listOf("Bad"),
                pros = listOf(
                    "Smooth",
                    "Faster"
                ),
                rating = 1
            ),
            CarItemUiModel(
                name = "Range Rover",
                image = CarImageResource.RANGE_ROVER,
                priceDisplay = "65k" ,
                cons = listOf("Bad"),
                pros = listOf(
                    "Smooth",
                    "Faster"
                ),
                rating = 3
            )
        )
}