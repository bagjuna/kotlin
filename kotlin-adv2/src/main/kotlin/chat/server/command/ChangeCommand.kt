package hello.chat.server.command

import hello.chat.server.Session
import hello.chat.server.SessionManager

class ChangeCommand(private val sessionManager: SessionManager) : Command {

    override fun execute(args: Array<String>, session: Session) {
        val oldUsername = session.username
        val newUsername = args[1]
        session.username = newUsername
        sessionManager.sendAll("${oldUsername}님이 ${newUsername}(으)로 닉네임을 변경했습니다.")
    }

}
