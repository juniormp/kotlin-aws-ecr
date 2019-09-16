package domain.product

import infrastructure.shipping.BookShippingService

class BookItemStrategy (private val shippingService : BookShippingService) : ProductItemStrategy {
    override fun processStrategy() {
        shippingService.performShipping()
    }
}