package hu.bme.mobilszoftver.money_exchange.model

import com.google.gson.annotations.SerializedName

data class Currency (
    @SerializedName("price")
    var price: Int? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("country")
    var country: String? = null
)