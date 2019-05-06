package hu.bme.mobilszoftver.money_exchange.model

import com.google.gson.annotations.SerializedName

data class Currency (
    @SerializedName("id")
    var id: Long? = null,
    @SerializedName("price")
    var price: Int? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("country")
    var country: String? = null,
    @SerializedName("is_favourite")
    var isFavourite: Boolean? = null,
    @SerializedName("flag")
    var flag: Image? = null
)