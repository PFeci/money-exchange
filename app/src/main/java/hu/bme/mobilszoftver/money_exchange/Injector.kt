package hu.bme.mobilszoftver.money_exchange

import android.app.Activity


val Activity.injector: MoneyExchangeApplicationComponent
    get() {
        return (this.applicationContext as MoneyExchangeApplication).injector
    }
