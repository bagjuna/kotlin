package hello.tcp.exception.close.reset

import hello.util.MyLogger.log
import java.net.ServerSocket


fun main() {
    val serverSocket = ServerSocket(12345)
    val socket = serverSocket.accept()
    log("소켓 연결: $socket")


    socket.close()
    serverSocket.close()
    log("소켓 종료: $socket")
}
