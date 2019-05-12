package hu.bme.mobilszoftver.money_exchange

import dagger.Component
import hu.bme.mobilszoftver.money_exchange.interactor.InteractorModule
import hu.bme.mobilszoftver.money_exchange.mock.MockNetworkModule
import hu.bme.mobilszoftver.money_exchange.test.CurrencyTest
import hu.bme.mobilszoftver.money_exchange.test.MainTest
import javax.inject.Singleton

@Singleton
@Component(modules = [MockNetworkModule::class, TestModule::class, InteractorModule::class])
interface TestComponent : MoneyExchangeApplicationComponent {
    fun inject(mainTest: MainTest)
    fun inject(currencyTest: CurrencyTest)
}
