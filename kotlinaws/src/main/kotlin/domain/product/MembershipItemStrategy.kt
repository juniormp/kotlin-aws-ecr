package domain.product

import infrastructure.membership.MembershipService
import infrastructure.shipping.PhysicalShippingService

class MembershipItemStrategy(private val membershipService : MembershipService) : ProductItemStrategy {
    override fun processStrategy() {
        membershipService.activateMembership()
    }
}