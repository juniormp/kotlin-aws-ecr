package domain.billing

import domain.order.Order
import java.util.*

class Payment (val order: Order, val paymentMethod: PaymentMethod) {

    private val paidAt = Date()
    private val authorizationNumber = paidAt.time
    val amount = order.totalAmount
    val invoice = Invoice(order)
}