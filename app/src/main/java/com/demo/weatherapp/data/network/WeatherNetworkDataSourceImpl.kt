package com.demo.weatherapp.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.demo.weatherapp.data.network.response.CurrentWeatherResponse
import com.demo.weatherapp.internal.NoConnectivityException

class WeatherNetworkDataSourceImpl(
    private val weatherStackApiService: WeatherStackApiService
) : WeatherNetworkDataSource {
    private val _downloadedCurrentWeather = MutableLiveData<CurrentWeatherResponse>()
    override val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>
        get() = _downloadedCurrentWeather

    override suspend fun fetchCurrentWeather(location: String, languageCode: String) {
        try {
            val fetchCurrentWeather = weatherStackApiService.getWeather(location, languageCode)
            _downloadedCurrentWeather.postValue(fetchCurrentWeather)
        } catch (e: NoConnectivityException) {
            Log.e("Connectivity", "No Internet Connection " + e)
        }
    }
}