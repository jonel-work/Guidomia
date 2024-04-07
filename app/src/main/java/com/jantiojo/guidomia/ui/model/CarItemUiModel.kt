package com.jantiojo.guidomia.ui.model

data class CarItemUiModel(
    val name: String,
    val image: CarImageResource,
    val priceDisplay: String,
    val rating: Int,
    val cons: List<String>,
    val pros: List<String>
) {

    fun doesMatchSearchQuery(query: String): Boolean {
        return name.contains(query, ignoreCase = true)
    }

}
