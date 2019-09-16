package domain.product

import infrastructure.mailer.DigitalMailerService
import org.junit.Test
import org.mockito.Mockito

class DigitalItemStrategyTest {

    @Test
    fun performDigitalItemStrategy(){
        val mailerService = Mockito.mock(DigitalMailerService::class.java)
        val itemStrategy = DigitalItemStrategy(mailerService)

        itemStrategy.processStrategy()

        Mockito.verify(mailerService).sendMail()
    }
}