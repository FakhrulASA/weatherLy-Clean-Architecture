package com.example.coroutineretrofit.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class WeatherDataHourly {
    @SerializedName("data")
    @Expose
    val data: List<Datum>? = null

    @SerializedName("error")
    @Expose
    var error: String? = null

    companion object {
        class Datum {
            @SerializedName("wind_cdir")
            @Expose
            val windCdir: String? = null

            @SerializedName("rh")
            @Expose
            val rh:  Double? = null

            @SerializedName("pod")
            @Expose
            val pod: String? = null

            @SerializedName("timestamp_utc")
            @Expose
            val timestampUtc: String? = null

            @SerializedName("pres")
            @Expose
            val pres:  Double? = null

            @SerializedName("solar_rad")
            @Expose
            val solarRad: Double? = null

            @SerializedName("ozone")
            @Expose
            val ozone: Double? = null

            @SerializedName("weather")
            @Expose
            val weather: Weather? = null

            @SerializedName("wind_gust_spd")
            @Expose
            val windGustSpd: Double? = null

            @SerializedName("timestamp_local")
            @Expose
            val timestampLocal: String? = null

            @SerializedName("snow_depth")
            @Expose
            val snowDepth:  Double? = null

            @SerializedName("clouds")
            @Expose
            val clouds:  Double? = null

            @SerializedName("ts")
            @Expose
            val ts:  Double? = null

            @SerializedName("wind_spd")
            @Expose
            val windSpd: Double? = null

            @SerializedName("pop")
            @Expose
            val pop:  Double? = null

            @SerializedName("wind_cdir_full")
            @Expose
            val windCdirFull: String? = null

            @SerializedName("slp")
            @Expose
            val slp:  Double? = null

            @SerializedName("dni")
            @Expose
            val dni: Double? = null

            @SerializedName("dewpt")
            @Expose
            val dewpt: Double? = null

            @SerializedName("snow")
            @Expose
            val snow:  Double? = null

            @SerializedName("uv")
            @Expose
            val uv: Double? = null

            @SerializedName("wind_dir")
            @Expose
            val windDir:  Double? = null

            @SerializedName("clouds_hi")
            @Expose
            val cloudsHi:  Double? = null

            @SerializedName("precip")
            @Expose
            val precip:  Double? = null

            @SerializedName("vis")
            @Expose
            val vis: Double? = null

            @SerializedName("dhi")
            @Expose
            val dhi: Double? = null

            @SerializedName("app_temp")
            @Expose
            val appTemp: Double? = null

            @SerializedName("datetime")
            @Expose
            val datetime: String? = null

            @SerializedName("temp")
            @Expose
            val temp: Double? = null

            @SerializedName("ghi")
            @Expose
            val ghi: Double? = null

            @SerializedName("clouds_mid")
            @Expose
            val cloudsMid:  Double? = null

            @SerializedName("clouds_low")
            @Expose
            val cloudsLow:  Double? = null

        }

        class Weather {
            @SerializedName("icon")
            @Expose
            val icon: String? = null

            @SerializedName("code")
            @Expose
            val code: Double? = null

            @SerializedName("description")
            @Expose
            val description: String? = null
        }
    }
}