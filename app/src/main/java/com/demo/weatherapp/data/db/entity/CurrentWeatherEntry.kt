package com.demo.weatherapp.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

const val CURRENT_WEATHER_ID = 0

@Entity(tableName = "current_weather")
data class CurrentWeatherEntry(
    val feelslike: Double,
    val observation_time: String,
    val precip: Double,
    val temparature: Double,
    val uv_index: Int,
    val visibility: Double,
    val weather_code: Int,
    val weather_descriptions: List<String>,
    val weather_icons: List<String>,
    val wind_dir: String,
    val wind_speed: Double,
    val is_day: String
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = CURRENT_WEATHER_ID
}