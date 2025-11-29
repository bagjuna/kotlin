package hello.chat.server

fun main() {

    val sessionManager = SessionManager()
    val PORT = 12345
    // commend 변경 예정
    val commandManager = CommandManagerV1(sessionManager)
    val server = Server(PORT, commandManager, sessionManager)
    server.start()


}


