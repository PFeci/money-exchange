package hu.bme.mobilszoftver.money_exchange.repository.room

import android.arch.persistence.room.Room
import android.content.Context
import hu.bme.mobilszoftver.money_exchange.repository.Repository
import java.util.*
import javax.inject.Inject

class RoomRepository @Inject constructor() : Repository {

    private lateinit var currencyDao: CurrencyDao;

    override fun open(context: Context) {
        currencyDao = Room.databaseBuilder(context, MyDatabase::class.java, "currency.db").build().roomDao()
    }

    override fun close() {
        // Empty
    }

    override fun getAllCurrency(): List<Currency> {
        return currencyDao.getAllCurrency()
    }

    override fun addCurrency(currency: Currency) {
        return currencyDao.addCurrency(currency);
    }

    override fun removeCurrency(currency: Currency) {
        return currencyDao.removeCurrency(currency)
    }

}