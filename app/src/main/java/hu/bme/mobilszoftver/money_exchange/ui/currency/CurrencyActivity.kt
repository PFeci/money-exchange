package hu.bme.mobilszoftver.money_exchange.ui.currency

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import hu.bme.mobilszoftver.money_exchange.R
import hu.bme.mobilszoftver.money_exchange.injector
import hu.bme.mobilszoftver.money_exchange.model.Currency
import hu.bme.mobilszoftver.money_exchange.ui.main.CurrencyAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.all_currency.*
import javax.inject.Inject

class CurrencyActivity: AppCompatActivity(), CurrencyScreen {

    @Inject
    lateinit var currencyPresenter: CurrencyPresenter
    private lateinit var listView: ListView
    private lateinit var listItems: ArrayList<Currency>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        setContentView(R.layout.all_currency)

        home_button_all_currency.setOnClickListener {
            finish()
        }

        listView = findViewById(R.id.currency_list_view)

        listView.setOnItemClickListener {
                _,_,position,_ -> run {
            listItems[position].isFavourite = listItems[position].isFavourite.not()
            currencyPresenter.updateFavouriteList(listItems[position])
            }
        }
    }

    override fun onStart() {
        super.onStart()
        currencyPresenter.attachScreen(this)
        currencyPresenter.showCurrencyList()
    }

    override fun onStop() {
        super.onStop()
        currencyPresenter.detachScreen()
    }


    override fun showAllCurrencies(currencyList: List<Currency>) {
        listItems = arrayListOf()
        for (i in 0 until currencyList.size) {
            val currency = currencyList[i]
            listItems.add(currency)
        }

        val adapter = CurrencyAdapter(this, listItems, -1)
        listView.adapter = adapter
    }
}