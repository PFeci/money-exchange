package hu.bme.mobilszoftver.money_exchange.interactor

import dagger.Module
import dagger.Provides
import hu.bme.mobilszoftver.money_exchange.interactor.currency.CurrencyInteractor
import hu.bme.mobilszoftver.money_exchange.network.CurrencyApi
import javax.inject.Singleton

@Module
class InteractorModule {

    @Provides
    @Singleton
    fun provideCurrencyInteractor(currencyApi: CurrencyApi) =
        CurrencyInteractor(currencyApi)

}