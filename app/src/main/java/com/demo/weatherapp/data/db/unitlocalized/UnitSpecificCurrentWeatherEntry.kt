package com.demo.weatherapp.data.db.unitlocalized

interface UnitSpecificCurrentWeatherEntry {

    val temperature: Double
    val windSpeed: Double
    val windDirection: String
    val precipitationVolume: Double
    val feelsLikeTemperature: Double
    val visibilityDistance: Double
}