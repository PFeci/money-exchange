package hu.bme.mobilszoftver.money_exchange.ui.currency

import hu.bme.mobilszoftver.money_exchange.model.Currency

interface CurrencyScreen {

    fun showAllCurrencies(currencyList: List<Currency>)
}