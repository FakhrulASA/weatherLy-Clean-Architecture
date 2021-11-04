package com.example.coroutineretrofit.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class PostData {
    @SerializedName("data")
    @Expose
    var data: List<Datum>? = null

    @SerializedName("count")
    @Expose
    var count: Double? = null

    @SerializedName("error")
    @Expose
    var error: String? = null

    companion object{
        class Datum{
            @SerializedName("rh")
            @Expose
            var rh: Double? = null

            @SerializedName("pod")
            @Expose
            var pod: String? = null

            @SerializedName("lon")
            @Expose
            var lon: Double? = null

            @SerializedName("pres")
            @Expose
            var pres: Double? = null

            @SerializedName("timezone")
            @Expose
            var timezone: String? = null

            @SerializedName("ob_time")
            @Expose
            var obTime: String? = null

            @SerializedName("country_code")
            @Expose
            var countryCode: String? = null

            @SerializedName("clouds")
            @Expose
            var clouds: Double? = null

            @SerializedName("ts")
            @Expose
            var ts: Double? = null

            @SerializedName("solar_rad")
            @Expose
            var solarRad: Double? = null

            @SerializedName("state_code")
            @Expose
            var stateCode: String? = null

            @SerializedName("city_name")
            @Expose
            var cityName: String? = null

            @SerializedName("wind_spd")
            @Expose
            var windSpd: Double? = null

            @SerializedName("wind_cdir_full")
            @Expose
            var windCdirFull: String? = null

            @SerializedName("wind_cdir")
            @Expose
            var windCdir: String? = null

            @SerializedName("slp")
            @Expose
            var slp: Double? = null

            @SerializedName("vis")
            @Expose
            var vis: Double? = null

            @SerializedName("h_angle")
            @Expose
            var hAngle: Double? = null

            @SerializedName("sunset")
            @Expose
            var sunset: String? = null

            @SerializedName("dni")
            @Expose
            var dni: Double? = null

            @SerializedName("dewpt")
            @Expose
            var dewpt: Double? = null

            @SerializedName("snow")
            @Expose
            var snow: Double? = null

            @SerializedName("uv")
            @Expose
            var uv: Double? = null

            @SerializedName("precip")
            @Expose
            var precip: Double? = null

            @SerializedName("wind_dir")
            @Expose
            var windDir: Double? = null

            @SerializedName("sunrise")
            @Expose
            var sunrise: String? = null

            @SerializedName("ghi")
            @Expose
            var ghi: Double? = null

            @SerializedName("dhi")
            @Expose
            var dhi: Double? = null

            @SerializedName("aqi")
            @Expose
            var aqi: Double? = null

            @SerializedName("lat")
            @Expose
            var lat: Double? = null

            @SerializedName("weather")
            @Expose
            var weather: Weather? = null

            @SerializedName("datetime")
            @Expose
            var datetime: String? = null

            @SerializedName("temp")
            @Expose
            var temp: Double? = null

            @SerializedName("station")
            @Expose
            var station: String? = null

            @SerializedName("elev_angle")
            @Expose
            var elevAngle: Double? = null

            @SerializedName("app_temp")
            @Expose
            var appTemp: Double? = null
        }
        class Weather{
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