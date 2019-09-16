package domain.product

import infrastructure.mailer.DigitalMailerService

class DigitalItemStrategy (private val mailerService : DigitalMailerService) : ProductItemStrategy {
    override fun processStrategy() {
        mailerService.sendMail()
    }
}