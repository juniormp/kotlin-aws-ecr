package domain.order

import domain.product.*
import infrastructure.shipping.BookShippingService
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.*

class OrderItemTest {

    @Test
    fun verifyIfProcessStrategyIsBeingCalled(){
        val type = Mockito.mock(ProductType.BOOK::class.java)
        val product = Product("Stairway to Heaven", type, 5.00)
        val orderItem = OrderItem(product, 1)
        val productItemStrategy = Mockito.mock(BookItemStrategy::class.java)
        `when`(product.type.getProductItemStrategy()).thenReturn(productItemStrategy)

        orderItem.close()

        Mockito.verify(productItemStrategy).processStrategy()
    }
}
