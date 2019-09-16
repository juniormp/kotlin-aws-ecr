package infrastructure.mailer

interface MailerService {
    fun sendMail() : String
}