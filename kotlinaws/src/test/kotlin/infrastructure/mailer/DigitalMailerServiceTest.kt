package infrastructure.mailer

import org.junit.Test
import kotlin.test.assertEquals

class DigitalMailerServiceTest {

    @Test
    fun sendEmailDescription(){
        var digitalMailerService = DigitalMailerService()

        var mailLabel = digitalMailerService.sendMail()

        assertEquals("Digital Item - Discount 10%", mailLabel)
    }
}