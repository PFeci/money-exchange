package hu.bme.mobilszoftver.money_exchange.ui.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ListView
import hu.bme.mobilszoftver.money_exchange.R
import hu.bme.mobilszoftver.money_exchange.injector
import hu.bme.mobilszoftver.money_exchange.model.Currency
import hu.bme.mobilszoftver.money_exchange.ui.currency.CurrencyActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(), MainScreen {

    @Inject
    lateinit var mainPresenter: MainPresenter
    private lateinit var listView: ListView
    private lateinit var listItems: ArrayList<Currency>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injector.inject(this)

        listView = findViewById(R.id.favourite_currency_list_view)

        all_currency_main.setOnClickListener {
            navigateToAllCurrency()
        }

        listView.setOnItemClickListener {
            _,_,position,_ ->
            mainPresenter.deleteFromFavouriteList(listItems[position])
        }

        currency_value.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                updateActualPrices()
            }
        })

    }

    override fun onStart() {
        super.onStart()
        mainPresenter.attachScreen(this)
        mainPresenter.showFavouriteCurrenciesList()
        updateActualPrices()
    }

    override fun onStop() {
        super.onStop()
        mainPresenter.detachScreen()
    }

    override fun showFavouriteCurrencies(currencyList: List<Currency>) {
        listItems = arrayListOf()
        for (i in 0 until currencyList.size) {
            val currency = currencyList[i]
            if (currency.isFavourite) {
                listItems.add(currency)
            }
        }

        val adapter = CurrencyAdapter(this, listItems, 0)
        listView.adapter = adapter
        updateActualPrices()
    }

    fun navigateToAllCurrency() {
        val intent = Intent(this, CurrencyActivity::class.java)
        startActivity(intent)
    }

    fun updateActualPrices() {
        val inputValue: EditText = findViewById<EditText>(R.id.currency_value)
        val actualValueString = inputValue.text.toString()
        var actualValue = 0
        if (actualValueString != "") {
            actualValue = actualValueString.toInt()
        }

        val adapter = CurrencyAdapter(this, listItems, actualValue)
        listView.adapter = adapter
    }

}
