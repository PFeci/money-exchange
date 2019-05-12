package hu.bme.mobilszoftver.money_exchange.ui.main

import hu.bme.mobilszoftver.money_exchange.model.Currency

interface MainScreen {
    fun showFavouriteCurrencies(currencyList: List<Currency>)

}