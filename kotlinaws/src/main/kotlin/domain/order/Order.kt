package domain.order

import domain.billing.Payment
import domain.billing.PaymentMethod
import domain.customer.Address
import domain.customer.Customer
import domain.product.Product
import java.util.*

class Order(val id : Int, val customer: Customer, val address: Address) {

    val items = mutableListOf<OrderItem>()
    var closedAt: Date? = null
        private set
    var payment: Payment? = null
        private set
    val totalAmount
        get() = items.sumByDouble { it.total }

    fun addProduct(product: Product, quantity : Int) {
        val productAlreadyAdded = items.any { it.product == product }
        if (productAlreadyAdded)
            throw Exception("The domain.product have already been added. Change the amount if you want more.")

        items.add(OrderItem(product, quantity))
    }

    fun pay(method : PaymentMethod) {
        if (this.payment != null)
            throw Exception("The order has already been paid!")

        if (items.count() == 0)
            throw Exception("Empty order can not be paid!")

        this.payment = Payment(this, method)

        close()
    }

    private fun close() {
        closedAt = Date()
        items.forEach { it.close() }
    }
}