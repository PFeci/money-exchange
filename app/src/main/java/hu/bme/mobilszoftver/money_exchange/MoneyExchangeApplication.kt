package hu.bme.mobilszoftver.money_exchange

import android.app.Application
import hu.bme.mobilszoftver.money_exchange.ui.UIModule

class MoneyExchangeApplication: Application() {

    lateinit var injector: MoneyExchangeApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerMoneyExchangeApplicationComponent.builder().uIModule(UIModule(this)).build()
    }
}