package infrastructure.mailer

class MembershipMailerService : MailerService {

    private val mailLabel : MailLabel = MailLabel("Hi, your membership is activated")

    override fun sendMail() : String {
        println("LOG: $mailLabel.description")
        return mailLabel.description
    }
}