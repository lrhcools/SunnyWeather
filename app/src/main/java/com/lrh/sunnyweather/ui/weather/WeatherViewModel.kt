package com.lrh.sunnyweather.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.lrh.sunnyweather.logic.Repository

class WeatherViewModel : ViewModel() {

    private val locationLiveData = MutableLiveData<com.lrh.sunnyweather.logic.model.Location>()

    var locationLng = ""

    var locationLat = ""

    var placeName = ""

    val weatherLiveData = Transformations.switchMap(locationLiveData) { location ->
        Repository.refreshWeather(location.lng, location.lat )
    }

    fun refreshWeather(lng: String, lat: String) {
        locationLiveData.value = com.lrh.sunnyweather.logic.model.Location(lng,lat)
    }

}