package infrastructure.shipping

class BookShippingService : ShippingService {

    private val shippingLabel : ShippingLabel = ShippingLabel("Book Item - Isento de impostos conforme disposto na Constituição Art. 150, VI, d.")

    override fun performShipping() : String{
        println("LOG: $shippingLabel.description")
        return shippingLabel.description
    }
}