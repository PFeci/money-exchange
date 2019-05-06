package hu.bme.mobilszoftver.money_exchange.repository

import dagger.Binds
import dagger.Module
import hu.bme.mobilszoftver.money_exchange.repository.room.RoomRepository
import javax.inject.Singleton

@Suppress("unused")
@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindRepository(roomRepository: RoomRepository): Repository

}
