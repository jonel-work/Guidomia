package com.jantiojo.guidomia.utils

import com.jantiojo.guidomia.ui.model.CarImageResource

object CarUtils {

    fun getCarMakeImageResource(make: String): CarImageResource {
        return when (make.lowercase()) {
            "land rover" -> CarImageResource.RANGE_ROVER
            "alpine" -> CarImageResource.ALPINE
            "bmw" -> CarImageResource.BMW
            "mercedes benz" -> CarImageResource.MERCEDEZ_BENZ
            else -> CarImageResource.TACOMA
        }
    }

}