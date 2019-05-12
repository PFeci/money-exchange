package hu.bme.mobilszoftver.money_exchange.test

import com.nhaarman.mockitokotlin2.mock
import hu.bme.mobilszoftver.money_exchange.model.Currency
import hu.bme.mobilszoftver.money_exchange.testInjector
import hu.bme.mobilszoftver.money_exchange.ui.currency.CurrencyPresenter
import hu.bme.mobilszoftver.money_exchange.ui.currency.CurrencyScreen
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
class CurrencyTest {
    @Inject
    lateinit var currencyPresenter: CurrencyPresenter

    private lateinit var currencyScreen: CurrencyScreen
    private lateinit var query: String

    @Before
    @Throws(Exception::class)
    fun setup() {
        testInjector.inject(this)
        currencyScreen = mock()
        currencyPresenter.attachScreen(currencyScreen)
    }

    @Test
    fun testUpdate() {
        val currency: Currency = Currency(3, 354.2f, "GBP", "Great Britain", false)
        currencyPresenter.updateFavouriteList(currency)
        verify(currencyScreen).showAllCurrencies(mutableListOf(
            Currency(1, 260.67f, "USD", "USA", false),
            Currency(2, 320.1f, "EUR", "European Union", false),
            Currency(3, 354.2f, "GBP", "Great Britain", true)
        ))
    }

    @Test
    fun testUpdate2() {
        val currency: Currency = Currency(1, 354.2f, "GBP", "Great Britain", true)
        currencyPresenter.updateFavouriteList(currency)
        verify(currencyScreen).showAllCurrencies(mutableListOf(
            Currency(1, 260.67f, "USD", "USA", false),
            Currency(2, 320.1f, "EUR", "European Union", false),
            Currency(3, 354.2f, "GBP", "Great Britain", false)
        ))
    }

    @After
    fun tearDown() {
        currencyPresenter.detachScreen()
    }
}