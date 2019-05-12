package hu.bme.mobilszoftver.money_exchange.repository

import android.content.Context
import java.util.*


interface Repository {

    fun getAllCurrency(): List<Currency>

    fun open(context: Context)

    fun close()

    fun addCurrency(currency: Currency)

    fun removeCurrency(currency: Currency)

}