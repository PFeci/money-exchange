package hu.bme.mobilszoftver.money_exchange.mock.interceptors

import android.net.Uri
import com.google.gson.Gson
import hu.bme.mobilszoftver.money_exchange.network.NetworkConfig
import okhttp3.Request
import okhttp3.Response

object CurrencyMock {

    fun process(request: Request): Response {
        val uri = Uri.parse(request.url().toString())

        val responseString: String
        val responseCode: Int
        val headers = request.headers()

        if (uri.path == NetworkConfig.ENDPOINT_PREFIX + "currency" && request.method() == "GET") {

            responseString = Gson().toJson({})
            responseCode = 200
        } else {
            responseString = "ERROR"
            responseCode = 503
        }

        return MockHelper.makeResponse(request, headers, responseCode, responseString)
    }

}