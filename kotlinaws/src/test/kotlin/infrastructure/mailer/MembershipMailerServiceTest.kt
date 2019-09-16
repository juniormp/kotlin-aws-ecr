package infrastructure.mailer

import org.junit.Test
import kotlin.test.assertEquals

class MembershipMailerServiceTest {
    @Test
    fun sendEmailDescription(){
        var membershipMailerService = MembershipMailerService()

        var mailLabel = membershipMailerService.sendMail()

        assertEquals("Hi, your membership is activated", mailLabel)
    }
}