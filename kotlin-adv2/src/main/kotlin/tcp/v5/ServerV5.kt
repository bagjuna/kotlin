package hello.tcp.v5

import hello.util.MyLogger.log
import java.net.ServerSocket

fun main() {
    val PORT = 12345
    log("서버 시작")
    val serverSocket = ServerSocket(PORT)

    while (true) {
        val socket = serverSocket.accept() // 블로킹
        log("소켓 연결: $socket")

        val session = SessionV5(socket)
        val thread = Thread(session)
        thread.start()
    }



}
