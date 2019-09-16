package domain.product

import infrastructure.shipping.PhysicalShippingService

class PhysicalItemStrategy(private val shippingService : PhysicalShippingService) : ProductItemStrategy {
    override fun processStrategy() {
        shippingService.performShipping()
    }
}