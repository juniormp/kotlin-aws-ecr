package infrastructure.shipping


import org.junit.Test
import kotlin.test.assertEquals


class PhysicalShippingServiceTest {
    @Test
    fun sendShippingLabelDescription(){
        var physicalShippingService = PhysicalShippingService()

        var shippingLabel = physicalShippingService.performShipping()

        assertEquals("Physical Item", shippingLabel)
    }
}