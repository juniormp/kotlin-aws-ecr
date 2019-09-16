package infrastructure.membership

import infrastructure.mailer.MembershipMailerService

class MembershipService(private val mailerService: MembershipMailerService)  {

    fun activateMembership() {
        println("LOG: Activating Membership ............ Done!")
        mailerService.sendMail()
    }
}

