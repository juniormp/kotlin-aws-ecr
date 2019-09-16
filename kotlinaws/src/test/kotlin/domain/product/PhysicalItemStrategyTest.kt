package domain.product

import infrastructure.shipping.PhysicalShippingService
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.verify

class PhysicalItemStrategyTest {

    @Test
    fun performPhysicalItemStrategy(){
        val shippingService = Mockito.mock(PhysicalShippingService::class.java)
        val itemStrategy = PhysicalItemStrategy(shippingService)

        itemStrategy.processStrategy()

        verify(shippingService).performShipping()
    }
}