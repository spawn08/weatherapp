package com.demo.weatherapp.data.db.unitlocalized

import androidx.room.ColumnInfo

class ImperialCurrentWeatherEntry(
    @ColumnInfo(name = "temparature")
    override val temperature: Double,

    @ColumnInfo(name = "wind_speed")
    override val windSpeed: Double,

    @ColumnInfo(name = "wind_dir")
    override val windDirection: String,

    @ColumnInfo(name = "precip")
    override val precipitationVolume: Double,

    @ColumnInfo(name = "feelslike")
    override val feelsLikeTemperature: Double,

    @ColumnInfo(name = "visibility")
    override val visibilityDistance: Double

) : UnitSpecificCurrentWeatherEntry {
}