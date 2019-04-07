package hu.bme.mobilszoftver.money_exchange.ui.main

import hu.bme.mobilszoftver.money_exchange.ui.Presenter

class MainPresenter : Presenter<MainScreen>() {

    fun showFavouriteCurrenciesList() {
        screen?.showFavouriteCurrencies()
    }
}
