package com.jantiojo.guidomia.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity("car")
data class Car(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
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
