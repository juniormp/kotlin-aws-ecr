package domain.billing

import domain.customer.Address
import domain.order.Order

class Invoice(private val order: Order) {
    val billingAddress: Address = order.address
    val shippingAddress: Address = order.address
}