package infrastructure.membership

import infrastructure.mailer.MembershipMailerService
import infrastructure.shipping.BookShippingService
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.*
import kotlin.test.assertEquals

class MembershipServiceTest {
    @Test
    fun verifyIfMembershipIsActivated(){
        val mailerService = Mockito.mock(MembershipMailerService::class.java)
        var membershipService = MembershipService(mailerService)

         membershipService.activateMembership()

        verify(mailerService).sendMail()
    }
}