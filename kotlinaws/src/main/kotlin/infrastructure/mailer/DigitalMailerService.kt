package infrastructure.mailer

class DigitalMailerService : MailerService {

    private val mailLabel : MailLabel = MailLabel("Digital Item - Discount 10%")

    override fun sendMail() : String {
        println("LOG: $mailLabel.description")
        return mailLabel.description
    }
}