package domain.product

import infrastructure.mailer.DigitalMailerService
import infrastructure.mailer.MembershipMailerService
import infrastructure.membership.MembershipService
import infrastructure.shipping.BookShippingService
import infrastructure.shipping.PhysicalShippingService

enum class ProductType {

    PHYSICAL {
        override fun getProductItemStrategy(): PhysicalItemStrategy {
            return PhysicalItemStrategy(PhysicalShippingService())
        }
    },

    BOOK {
        override fun getProductItemStrategy(): BookItemStrategy {
            return BookItemStrategy(BookShippingService())
        }
    },

    DIGITAL {
        override fun getProductItemStrategy(): DigitalItemStrategy {
            return DigitalItemStrategy(DigitalMailerService())
        }
    },

    MEMBERSHIP {
        override fun getProductItemStrategy(): MembershipItemStrategy {
            return MembershipItemStrategy(MembershipService(MembershipMailerService()))
        }
    };

    abstract fun getProductItemStrategy(): ProductItemStrategy
}

