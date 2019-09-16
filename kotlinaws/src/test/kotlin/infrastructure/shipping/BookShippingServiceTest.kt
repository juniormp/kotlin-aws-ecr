package infrastructure.shipping

import org.junit.Test
import kotlin.test.assertEquals

class BookShippingServiceTest {
    @Test
    fun sendShippingLabelDescription(){
        var bookShippingService = BookShippingService()

        var shippingLabel = bookShippingService.performShipping()

        assertEquals("Book Item - Isento de impostos conforme disposto na Constituição Art. 150, VI, d.", shippingLabel)
    }
}