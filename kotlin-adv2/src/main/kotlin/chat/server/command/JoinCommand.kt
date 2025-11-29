package hello.chat.server.command

import hello.chat.server.Session
import hello.chat.server.SessionManager

class JoinCommand(private val sessionManager: SessionManager): Command {

    override fun execute(args: List<String>, session: Session) {
        val username = args[1]
        session.username = username
        sessionManager.sendAll("${username}님이 입장했습니다.")
    }
}
