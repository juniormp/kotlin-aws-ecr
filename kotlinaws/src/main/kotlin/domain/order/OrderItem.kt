package domain.order

import domain.product.*

data class OrderItem(val product: Product, val quantity: Int) {
    val total get() = product.price * quantity

    fun close() {
        val productItemStrategy = getProductItemStrategy()
        productItemStrategy.processStrategy()
    }

    private fun getProductItemStrategy() : ProductItemStrategy {
        return product.type.getProductItemStrategy()
    }
}
