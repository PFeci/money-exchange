package hu.bme.mobilszoftver.money_exchange.network

import hu.bme.mobilszoftver.money_exchange.model.Currency
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface CurrencyApi {

  @GET("currency")
  fun getAllFavouriteCurrencies(): Call<List<Currency>>

  @POST("currency")
  fun update(@Body currency: Currency): Call<ResponseBody>

  @DELETE("currency/{id}")
  fun delete(@Path("id") id: Long?): Call<ResponseBody>

  @GET("currency/exchange_rates")
  fun getAllCurrenciesWithExchangeRates(): Call<List<Currency>>

}