package hello.chat.server.command

import hello.chat.server.Session
import hello.chat.server.SessionManager

class MessageCommand(private val sessionManager: SessionManager): Command {

    override fun execute(args: Array<String>, session: Session) {
        val message = args.drop(1).joinToString(" ")
        sessionManager.sendAll("[${session.username}]: $message")
    }

}
