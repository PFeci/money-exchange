package hu.bme.mobilszoftver.money_exchange.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import hu.bme.mobilszoftver.money_exchange.R
import javax.inject.Inject


class MainActivity : AppCompatActivity(), MainScreen {

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        mainPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        mainPresenter.detachScreen()
    }

    override fun showFavouriteCurrencies() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
