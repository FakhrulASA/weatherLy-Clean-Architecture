package com.example.coroutineretrofit.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class PostData {

    @SerializedName("time")
    @Expose
    var time: Time? = null

    @SerializedName("disclaimer")
    @Expose
    var disclaimer: String? = null

    @SerializedName("chartName")
    @Expose
    var chartName: String? = null

    @SerializedName("bpi")
    @Expose
    var bpi: Bpi? = null

    companion object{
        class Eur {
            @SerializedName("code")
            @Expose
            var code: String? = null

            @SerializedName("symbol")
            @Expose
            var symbol: String? = null

            @SerializedName("rate")
            @Expose
            var rate: String? = null

            @SerializedName("description")
            @Expose
            var description: String? = null

            @SerializedName("rate_float")
            @Expose
            var rateFloat: Double? = null
        }

        class Gbp {
            @SerializedName("code")
            @Expose
            var code: String? = null

            @SerializedName("symbol")
            @Expose
            var symbol: String? = null

            @SerializedName("rate")
            @Expose
            var rate: String? = null

            @SerializedName("description")
            @Expose
            var description: String? = null

            @SerializedName("rate_float")
            @Expose
            var rateFloat: Double? = null
        }
        class Time {
            @SerializedName("updated")
            @Expose
            var updated: String? = null

            @SerializedName("updatedISO")
            @Expose
            var updatedISO: String? = null

            @SerializedName("updateduk")
            @Expose
            var updateduk: String? = null
        }
        class Usd {
            @SerializedName("code")
            @Expose
            var code: String? = null

            @SerializedName("symbol")
            @Expose
            var symbol: String? = null

            @SerializedName("rate")
            @Expose
            var rate: String? = null

            @SerializedName("description")
            @Expose
            var description: String? = null

            @SerializedName("rate_float")
            @Expose
            var rateFloat: Double? = null
        }
        class Bpi {
            @SerializedName("USD")
            @Expose
            var usd: Usd? = null

            @SerializedName("GBP")
            @Expose
            var gbp: Gbp? = null

            @SerializedName("EUR")
            @Expose
            var eur: Eur? = null
        }
    }
}