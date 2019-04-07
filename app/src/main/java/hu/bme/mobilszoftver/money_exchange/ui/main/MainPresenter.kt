package hu.bme.mobilszoftver.money_exchange.ui.main

import hu.bme.mobilszoftver.money_exchange.interactor.currency.CurrencyInteractor
import hu.bme.mobilszoftver.money_exchange.ui.Presenter
import javax.inject.Inject

class MainPresenter @Inject constructor(private val currencyInteractor: CurrencyInteractor): Presenter<MainScreen>() {

    fun showFavouriteCurrenciesList() {
        screen?.showFavouriteCurrencies()
    }
}
