package domain.product

import infrastructure.shipping.BookShippingService
import org.junit.Test
import org.mockito.Mockito

class BookItemStrategyTest {

    @Test
    fun performBookItemStrategy(){
        val shippingService = Mockito.mock(BookShippingService::class.java)
        val itemStrategy = BookItemStrategy(shippingService)

        itemStrategy.processStrategy()

        Mockito.verify(shippingService).performShipping()
    }
}