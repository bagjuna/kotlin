package hello.chat.server.command

import hello.chat.server.Session
import hello.chat.server.SessionManager

class UsersCommand(private val sessionManager: SessionManager) : Command {

    override fun execute(args: List<String>, session: Session) {
        val usernames = sessionManager.getAllUsernames()

//        val sb = StringBuilder()
//        sb.append("전체 접속자: ${usernames.size} \n")
//        for (username in usernames) {
//            sb.append(" - ").append(username).append("\n")
//        }

        val message = "전체 접속자: ${usernames.size}\n" +
                usernames.joinToString("\n") { " - $it" }
        session.send(message)



    }
}
