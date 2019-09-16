package infrastructure.shipping

class PhysicalShippingService : ShippingService {

    private val shippingLabel : ShippingLabel = ShippingLabel("Physical Item")

    override fun performShipping(): String {
        println("LOG: $shippingLabel.description")
        return shippingLabel.description
    }
}