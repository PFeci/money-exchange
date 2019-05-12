package hu.bme.mobilszoftver.money_exchange.test

import com.nhaarman.mockitokotlin2.mock
import hu.bme.mobilszoftver.money_exchange.model.Currency
import hu.bme.mobilszoftver.money_exchange.testInjector
import hu.bme.mobilszoftver.money_exchange.ui.main.MainPresenter
import hu.bme.mobilszoftver.money_exchange.ui.main.MainScreen
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
class MainTest {
    @Inject
    lateinit var mainPresenter: MainPresenter
    private lateinit var mainScreen: MainScreen

    @Throws(Exception::class)
    @Before
    fun setup() {
        testInjector.inject(this)
        mainScreen = mock()
        mainPresenter.attachScreen(mainScreen)
    }

    @Test
    fun testGetAll() {
        mainPresenter.showFavouriteCurrenciesList()
        //org.junit.Assert.assertEquals("text","text")
        verify(mainScreen).showFavouriteCurrencies(mutableListOf(
            Currency(1, 260.67f, "USD", "USA", true),
            Currency(2, 320.1f, "EUR", "European Union", false),
            Currency(3, 354.2f, "GBP", "Great Britain", false)
        ))
    }

    @Test
    fun deleteFromFavouriteList() {
        val currency: Currency = Currency(1, 260.67f, "USD", "USA", true)
        mainPresenter.deleteFromFavouriteList(currency)
        verify(mainScreen).showFavouriteCurrencies(mutableListOf(
            Currency(1, 260.67f, "USD", "USA", false),
            Currency(2, 320.1f, "EUR", "European Union", false),
            Currency(3, 354.2f, "GBP", "Great Britain", false)
        ))
    }

    @After
    fun tearDown() {
        mainPresenter.detachScreen()
    }
}