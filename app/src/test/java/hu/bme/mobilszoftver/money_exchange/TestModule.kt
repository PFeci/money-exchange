package hu.bme.mobilszoftver.money_exchange

import android.content.Context
import dagger.Module
import dagger.Provides
import hu.bme.mobilszoftver.money_exchange.interactor.currency.CurrencyInteractor
import hu.bme.mobilszoftver.money_exchange.ui.currency.CurrencyPresenter
import hu.bme.mobilszoftver.money_exchange.ui.main.MainPresenter
import hu.bme.mobilszoftver.money_exchange.utils.UiExecutor
import java.util.concurrent.Executor
import javax.inject.Singleton

@Module
class TestModule(private val context: Context) {

    @Provides
    fun provideContext() = context

    @Provides
    @Singleton
    fun provideMainPresenter(currencyInteractor: CurrencyInteractor) = MainPresenter(currencyInteractor)

    @Provides
    @Singleton
    fun provideCurrencyPresenter(currencyInteractor: CurrencyInteractor) = CurrencyPresenter(currencyInteractor)

    @Provides
    @Singleton
    fun provideNetworkExecutor(): Executor = UiExecutor()
}
