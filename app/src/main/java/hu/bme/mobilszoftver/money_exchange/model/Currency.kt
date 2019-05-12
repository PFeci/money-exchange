package hu.bme.mobilszoftver.money_exchange.model

import com.google.gson.annotations.SerializedName

data class Currency (
    @SerializedName("id")
    var id: Long? = null,
    @SerializedName("price")
    var price: Float = 0f,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("country")
    var country: String? = null,
    @SerializedName("is_favourite")
    var isFavourite: Boolean = false,
    @SerializedName("flag")
    var flag: Image? = null
)