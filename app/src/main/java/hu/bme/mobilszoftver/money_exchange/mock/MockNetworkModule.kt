package hu.bme.mobilszoftver.money_exchange.mock

import dagger.Module
import dagger.Provides
import hu.bme.mobilszoftver.money_exchange.mock.interceptors.MockInterceptor
import hu.bme.mobilszoftver.money_exchange.network.CurrencyApi
import hu.bme.mobilszoftver.money_exchange.network.NetworkModule
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class MockNetworkModule {

    private val networkModule = NetworkModule()

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return networkModule.provideOkHttpClient()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(builder: OkHttpClient.Builder): OkHttpClient {
        builder.interceptors().add(builder.interceptors().size, MockInterceptor())

        return builder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return networkModule.provideRetrofit(client)
    }

    @Provides
    @Singleton
    fun provideStuffsApi(client: OkHttpClient): CurrencyApi {
        return networkModule.provideCurrencyApi(client)
    }
}