package com.jantiojo.guidomia.ui.model

import androidx.annotation.DrawableRes
import com.jantiojo.guidomia.R

/**
 * Drawable Resource Mapper for Car's Image
 */
enum class CarImageResource(@DrawableRes val imageRes: Int) {
    ALPINE(R.drawable.alpine_roadster),
    BMW(R.drawable.bmw_330i),
    MERCEDEZ_BENZ(R.drawable.mercedez_benz_glc),
    RANG_ROVER(R.drawable.range_rover),
    TACOMA(R.drawable.tacoma),
}