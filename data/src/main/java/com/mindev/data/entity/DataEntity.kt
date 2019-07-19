package com.mindev.data.entity

sealed class DataEntity {
    data class NewsInfo(
        val comments_count: Int? = 0,
        val domain: String? = "",
        val id: Int? = 0,
        val points: Int? = 0,
        val time: Int? = 0,
        val time_ago: String? = "",
        val title: String? = "",
        val type: String? = "",
        val url: String? = "",
        val user: String? = ""
    ) : DataEntity()

    data class WeatherInfo(
        val city: City,
        val cnt: Int,
        val cod: String,
        val list: List<X>,
        val message: Double
    ): DataEntity()

    data class City(
        val coord: Coord,
        val country: String,
        val id: Int,
        val name: String
    )

    data class Coord(
        val lat: Double,
        val lon: Double
    )

    data class X(
        val clouds: Clouds,
        val dt: Int,
        val dt_txt: String,
        val main: Main,
        val rain: Rain,
        val snow: Snow,
        val sys: Sys,
        val weather: List<Weather>,
        val wind: Wind
    )

    data class Main(
        val grnd_level: Double,
        val humidity: Int,
        val pressure: Double,
        val sea_level: Double,
        val temp: Double,
        val temp_kf: Int,
        val temp_max: Double,
        val temp_min: Double
    )

    data class Wind(
        val deg: Double,
        val speed: Double
    )

    data class Sys(
        val pod: String
    )

    data class Weather(
        val description: String,
        val icon: String,
        val id: Int,
        val main: String
    )

    data class Clouds(
        val all: Int
    )

    class Rain(
    )

    class Snow(
    )
}
