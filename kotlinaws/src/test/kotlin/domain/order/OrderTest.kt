package domain.order

import domain.billing.CreditCard
import domain.customer.Address
import domain.customer.Customer
import domain.product.Product
import domain.product.ProductType
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class OrderTest {
    private val address = Address(1234567)
    private val customer = Customer("Mauricio", address)
    private val order = Order(1, customer, address)

    @Test
    fun addProductToOrder() {
        val product = Product("Flowered t-shirt", ProductType.PHYSICAL, 35.00)

        order.addProduct(product, 1)

        assert(order.items.any { it -> it.product == product })
    }

    @Test
    fun throwExceptionForDuplicatedProduct() {
        assertFailsWith(Exception::class, "The product have already been added. Change the amount if you want more.") {
            val product = Product("Flowered t-shirt", ProductType.PHYSICAL, 35.00)
            val sameProduct = Product("Flowered t-shirt", ProductType.PHYSICAL, 35.00)

            order.addProduct(product, 1)
            order.addProduct(sameProduct, 1)
        }
    }

    @Test
    fun performPaymentOrder() {
        val paymentMethod = CreditCard("43567890-987654367")
        val product = Product("Flowered t-shirt", ProductType.PHYSICAL, 35.00)
        order.addProduct(product, 1)

        order.pay(paymentMethod)

        assertEquals(order.totalAmount, order.payment?.amount)
    }

    @Test
    fun throwExceptionForPaidOrder() {
        val paymentMethod = CreditCard("43567890-987654367")
        val product = Product("Flowered t-shirt", ProductType.PHYSICAL, 35.00)
        order.addProduct(product, 1)
        order.pay(paymentMethod)

        assertFailsWith(Exception::class, "The order has already been paid!") {
            order.pay(paymentMethod)
        }
    }

    @Test
    fun throwExceptionForEmptyOrder() {
        assertFailsWith(Exception::class, "Empty order can not be paid!") {
            val paymentMethod = CreditCard("43567890-987654367")

            order.pay(paymentMethod)
        }
    }
}