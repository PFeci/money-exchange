package hu.bme.mobilszoftver.money_exchange

import dagger.Component
import hu.bme.mobilszoftver.money_exchange.interactor.InteractorModule
import hu.bme.mobilszoftver.money_exchange.ui.UIModule
import hu.bme.mobilszoftver.money_exchange.ui.main.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, InteractorModule::class])
interface MoneyExchangeApplicationComponent {
    fun inject(mainActivity: MainActivity)
}