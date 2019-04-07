package hu.bme.mobilszoftver.money_exchange.model

import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("url")
    var url: String? = null,
    @SerializedName("height")
    var height: Int? = null,
    @SerializedName("width")
    var width: Int? = null
)