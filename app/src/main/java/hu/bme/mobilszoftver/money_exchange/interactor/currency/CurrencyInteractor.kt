package hu.bme.mobilszoftver.money_exchange.interactor.currency

import hu.bme.mobilszoftver.money_exchange.model.Currency
import hu.bme.mobilszoftver.money_exchange.network.CurrencyApi
import java.lang.Exception
import javax.inject.Inject

class CurrencyInteractor @Inject constructor(private var currencyApi: CurrencyApi){

    fun getAllCurrenciesFromFavouriteList() {

        try {
            val query = currencyApi.getAllFavouriteCurrencies();
            val response = query.execute();

            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
        } catch (e: Exception) {

        }
    }

    fun addCurrencyToFavouriteList(currency: Currency) {
        try {
            val query = currencyApi.update(currency);
            val response = query.execute();

            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
        } catch (e: Exception) {

        }
    }

    fun deleteCurrencyFromFavouriteList(currency: Currency) {
        try {
            val query = currencyApi.delete(currency.id);
            val response = query.execute();

            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
        } catch (e: Exception) {

        }
    }

    fun getAllCurrenciesWithExchangeRate() {
        try {
            val query = currencyApi.getAllCurrenciesWithExchangeRates();
            val response = query.execute();

            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
        } catch (e: Exception) {

        }
    }
}