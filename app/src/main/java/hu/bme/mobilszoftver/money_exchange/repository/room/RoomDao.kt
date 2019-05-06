package hu.bme.mobilszoftver.money_exchange.repository.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import java.util.*

@Dao
interface CurrencyDao {

    @Query("SELECT * FROM currency")
    fun getAllCurrency(): List<Currency>

    @Insert
    fun addCurrency(currency: Currency)

    @Delete
    fun removeCurrency(currency: Currency)
}