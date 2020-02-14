package com.demo.weatherapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.demo.weatherapp.data.db.entity.CURRENT_WEATHER_ID
import com.demo.weatherapp.data.db.entity.CurrentWeatherEntry
import com.demo.weatherapp.data.db.unitlocalized.ImperialCurrentWeatherEntry

@Dao
interface CurrentWeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(weatherEntry: CurrentWeatherEntry)

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherMetric(): LiveData<ImperialCurrentWeatherEntry>

}