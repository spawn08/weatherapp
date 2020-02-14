package com.demo.weatherapp.data.network.response

import com.demo.weatherapp.data.db.entity.CurrentWeatherEntry
import com.demo.weatherapp.data.db.entity.Location
import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(

    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry,

    val location: Location
)