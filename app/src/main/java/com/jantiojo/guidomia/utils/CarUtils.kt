package com.jantiojo.guidomia.utils

import android.icu.number.Notation
import android.icu.number.NumberFormatter
import android.icu.number.Precision
import android.icu.text.CompactDecimalFormat
import android.os.Build
import com.jantiojo.guidomia.ui.model.CarImageResource
import java.util.Locale

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

    fun priceCompactShortFormat(
        price: Int,
        maxSignificantDigits: Int = 3,
        locale: Locale = Locale.ENGLISH
    ): String {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            NumberFormatter.with()
                .notation(Notation.compactShort())
                .precision(Precision.maxSignificantDigits(maxSignificantDigits))
                .locale(locale)
                .format(price)
                .toString()
        } else {
            convertNumber(price, locale).orEmpty()
        }
    }

    private fun convertNumber(number: Int, locale: Locale): String? {
        val compactDecimalFormat: CompactDecimalFormat =
            CompactDecimalFormat.getInstance(locale, CompactDecimalFormat.CompactStyle.SHORT)
        return compactDecimalFormat.format(number.toLong())
    }
}