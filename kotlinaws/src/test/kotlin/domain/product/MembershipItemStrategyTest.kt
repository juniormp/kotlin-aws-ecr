package domain.product

import infrastructure.membership.MembershipService
import org.junit.Test
import org.mockito.Mockito

class MembershipItemStrategyTest {

    @Test
    fun performMembershipItemStrategy(){
        val membershipService = Mockito.mock(MembershipService::class.java)
        val itemStrategy = MembershipItemStrategy(membershipService)

        itemStrategy.processStrategy()

        Mockito.verify(membershipService).activateMembership()
    }
}