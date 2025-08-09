package org.example.bookapp.book.data.database

import androidx.room.TypeConverter
import kotlinx.serialization.json.Json

object StringListTypeConverter {

    @TypeConverter
    fun fromStringList(list: List<String>): String {
//        return list.joinToString(",")
        return Json.encodeToString(list)
    }

    @TypeConverter
    fun toStringList(string: String): List<String> {
//        return string.split(",")
        return Json.decodeFromString(string)
    }

}