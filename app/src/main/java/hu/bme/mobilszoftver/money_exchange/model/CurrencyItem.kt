package hu.bme.mobilszoftver.money_exchange.model

import com.google.gson.annotations.SerializedName

data class CurrencyItem (
    @SerializedName("value")
    var value: Int? = null,
    @SerializedName("image")
    var image: Image? = null,
    @SerializedName("is_favourite")
    var isFavourite: Boolean? = null
)
