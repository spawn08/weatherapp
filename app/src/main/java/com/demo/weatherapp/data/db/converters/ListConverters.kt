package com.demo.weatherapp.data.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*


object ListConverters {

    var gson = Gson()

    @TypeConverter
    @JvmStatic
    fun stringToList(data: String?) : List<String>{
            if (data == null){
                return Collections.emptyList();
            }
        val listType: Type =
            object : TypeToken<List<String?>?>() {}.type

        return gson.fromJson(data, listType)
    }

    @TypeConverter
    @JvmStatic
    fun someObjectListToString(someObjects: List<String?>?): String? {
        return gson.toJson(someObjects)
    }
}

