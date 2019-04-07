package hu.bme.mobilszoftver.money_exchange.ui

import android.content.Context
import dagger.Module
import dagger.Provides
import hu.bme.mobilszoftver.money_exchange.interactor.currency.CurrencyInteractor
import hu.bme.mobilszoftver.money_exchange.ui.main.MainPresenter
import javax.inject.Singleton

@Module
class UIModule(private val context: Context) {

    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun mainPresenter(currencyInteractor: CurrencyInteractor) = MainPresenter(currencyInteractor)

}
