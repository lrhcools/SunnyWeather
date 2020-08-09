package com.lrh.sunnyweather.logic.model

data class Weather(val realTime: RealtimeResponse.RealTime,val daily: DailyResponse.Daily) {
}