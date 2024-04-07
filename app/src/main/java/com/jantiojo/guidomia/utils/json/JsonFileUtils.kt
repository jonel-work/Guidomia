package com.jantiojo.guidomia.utils.json

import android.content.Context
import kotlinx.serialization.json.Json

object JsonFileUtils {

    fun parseJsonFile(context: Context, fileName: String): Result<String> {
        return runCatching {
            context.assets.open(fileName).bufferedReader().use { it.readText() }
        }
    }

    inline fun <reified T> fromJsonFile(jsonFile: String): Result<T> {
        return runCatching {
            Json.decodeFromString(jsonFile)
        }
    }
}