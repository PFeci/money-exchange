package hu.bme.mobilszoftver.money_exchange.mock.interceptors

import android.net.Uri
import com.google.gson.Gson
import com.google.gson.JsonParser
import hu.bme.mobilszoftver.money_exchange.model.Currency
import hu.bme.mobilszoftver.money_exchange.network.NetworkConfig
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response

object CurrencyMock {

    var currencList: MutableList<Currency> = mutableListOf(
        Currency(1, 260.67f, "USD", "USA", true),
        Currency(2, 320.1f, "EUR", "European Union", false),
        Currency(3, 354.2f, "GBP", "Great Britain", false)
    )

    fun process(request: Request): Response {
        val uri = Uri.parse(request.url().toString())

        val responseString: String
        val responseCode: Int
        val headers = request.headers()

        val pathWithoutId = uri.path.substring(0, uri.path.lastIndexOf("/"))
        val id = uri.path.substring(uri.path.lastIndexOf("/") + 1)


        if (uri.path == NetworkConfig.ENDPOINT_PREFIX + "currency" && request.method() == "GET") {

            responseString = Gson().toJson(currencList)
            responseCode = 200
        } else if (pathWithoutId == NetworkConfig.ENDPOINT_PREFIX + "currency" && request.method() == "DELETE") {
            val deleteCurrency: Currency = currencList.find {
                currency -> id == currency.id.toString()
            } as Currency
            deleteCurrency.isFavourite = deleteCurrency.isFavourite.not()

            responseString = Gson().toJson("Successful delete operation!")
            responseCode = 200
        } else if (pathWithoutId == NetworkConfig.ENDPOINT_PREFIX + "currency" && request.method() == "PUT") {
            val updateCurrency = currencList.find {
                    currency -> id == currency.id.toString()
            } as Currency
            updateCurrency.isFavourite = updateCurrency.isFavourite.not()

            responseString = Gson().toJson("Successful update operation!")
            responseCode = 200
        }
        else {
            responseString = "ERROR"
            responseCode = 503
        }

        return MockHelper.makeResponse(request, headers, responseCode, responseString)
    }

}