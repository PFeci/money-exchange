package hu.bme.mobilszoftver.money_exchange.ui.currency

import hu.bme.mobilszoftver.money_exchange.interactor.currency.CurrencyInteractor
import hu.bme.mobilszoftver.money_exchange.model.Currency
import hu.bme.mobilszoftver.money_exchange.ui.Presenter
import javax.inject.Inject

class CurrencyPresenter @Inject constructor(private val currencyInteractor: CurrencyInteractor): Presenter<CurrencyScreen>() {
    fun showCurrencyList() {
        val currencyList = currencyInteractor.getAllCurrenciesFromFavouriteList()
        screen?.showAllCurrencies(currencyList)
    }

    fun updateFavouriteList(currency: Currency) {
        currencyInteractor.updateFavouriteList(currency)
        showCurrencyList()
    }
}