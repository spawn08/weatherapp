package com.demo.weatherapp.data.network

import com.demo.weatherapp.data.network.response.CurrentWeatherResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


const val API_KEY = "05be15fb9ca355a1f5880b2521c0903e"

//http://api.weatherstack.com/current?access_key=05be15fb9ca355a1f5880b2521c0903e&query=New%20York
interface WeatherStackApiService {

    @GET("current")
    suspend fun getWeather(
        @Query("query") query: String,
        @Query("lang") language: String = "en"
    ): CurrentWeatherResponse

    companion object {
        operator fun invoke(
            connectivityInterceptor: ConnectivityInterceptor
        ): WeatherStackApiService {
            val requestInterceptor = Interceptor { chain ->
                val url =
                    chain.request().url().newBuilder().addQueryParameter("access_key",
                        API_KEY
                    ).build()

                val request = chain.request().newBuilder().url(url).build()

                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(connectivityInterceptor)
                .build()
            return Retrofit.Builder().client(okHttpClient).baseUrl("http://api.weatherstack.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherStackApiService::class.java)
        }
    }

}