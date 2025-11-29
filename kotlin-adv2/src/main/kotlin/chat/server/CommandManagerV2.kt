package hello.chat.server

import hello.util.MyLogger.log
import java.io.IOException

class CommandManagerV2(private val sessionManager: SessionManager) : CommandManager {

    val DELIMITER = "|"
    override fun execute(totalMessage: String, session: Session) {

        // /join|juna
        when{
            totalMessage.startsWith("/join") -> {
                val split = totalMessage.split(DELIMITER)
                val userName = split[1]
                session.username = userName
                sessionManager.sendAll("${userName}님이 입장했습니다.")
            }
            totalMessage.startsWith("/message") -> {
                log("message command 실행 $totalMessage")
                val split = totalMessage.split(DELIMITER)
                for (string in split) {
                    log("split: $string")
                }
                val message = split[1]
                // [juna] hello
                val sendMessage = "[${session.username}] $message"
                sessionManager.sendAll(sendMessage)

            }
            totalMessage.startsWith("/change") -> {
                val split = totalMessage.split(DELIMITER)
                val newUserName = split[1]
                val oldUserName = session.username
                session.username = newUserName
                sessionManager.sendAll("${oldUserName}님이 ${newUserName}님으로 이름을 변경했습니다.")
            }
            totalMessage.startsWith("/users") -> {
                val usernames = sessionManager.getAllUsernames()
//                val sb = StringBuilder()
//                sb.append("전체 접속자 : ").append(usernames.size).append("\n")
//                for (username in usernames) {
//                    sb.append(" - ").append(username).append("\n")
//                }
//                val sendMessage = sb.toString()
                val sendMessage = "현재 접속자: ${usernames.size}명\n - " + usernames.joinToString("\n - ")
                session.send(sendMessage)
            }
            totalMessage.startsWith("/exit") -> {
                throw IOException("exit")
            }

        }

    }
}
