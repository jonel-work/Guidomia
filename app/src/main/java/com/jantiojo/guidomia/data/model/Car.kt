package com.jantiojo.guidomia.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Car(
    val consList: List<String>,
    val customerPrice: Int,
    val make: String,
    val marketPrice: Int,
    val model: String,
    val prosList: List<String>,
    val rating: Int
) {
    fun doesMatchSearchQuery(makeText: String, modelText: String): Boolean {
        return make.equals(makeText, ignoreCase = true)
                || model.equals(modelText, ignoreCase = true)
    }
}
