package hu.bme.mobilszoftver.money_exchange.repository.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import java.util.*

@Database(
    entities = [Currency::class],
    version = 1,
    exportSchema = false
)
abstract class MyDatabase : RoomDatabase() {

    abstract fun roomDao(): CurrencyDao

}