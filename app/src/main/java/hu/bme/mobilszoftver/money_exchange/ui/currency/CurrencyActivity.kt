package hu.bme.mobilszoftver.money_exchange.ui.currency

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import hu.bme.mobilszoftver.money_exchange.R
import javax.inject.Inject

class CurrencyActivity: AppCompatActivity(), CurrencyScreen {

    @Inject
    lateinit var currencyPresenter: CurrencyPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        currencyPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        currencyPresenter.detachScreen()
    }


    override fun showAllCurrencies() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}