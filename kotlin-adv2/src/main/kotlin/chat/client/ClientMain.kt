package hello.chat.client

import hello.util.MyLogger.log


fun main() {

    val PORT = 12345
    log("클라이언트 시작")
    Client("localhost", PORT).start()

}
