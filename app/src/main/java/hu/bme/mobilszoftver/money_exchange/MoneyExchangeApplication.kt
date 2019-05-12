package hu.bme.mobilszoftver.money_exchange

import android.app.Application
import com.google.firebase.analytics.FirebaseAnalytics
import hu.bme.mobilszoftver.money_exchange.ui.UIModule



class MoneyExchangeApplication: Application() {

    lateinit var injector: MoneyExchangeApplicationComponent

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate() {
        super.onCreate()
        firebaseAnalytics = FirebaseAnalytics.getInstance(this)

        injector = DaggerMoneyExchangeApplicationComponent.builder().uIModule(UIModule(this)).build()
    }

    @Synchronized
    fun getFirebase(): FirebaseAnalytics {
        return firebaseAnalytics
    }

}