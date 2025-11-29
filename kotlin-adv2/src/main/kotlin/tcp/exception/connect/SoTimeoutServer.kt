package hello.tcp.exception.connect

import java.net.ServerSocket


fun main() {
    val serverSocket = ServerSocket(12345)
    val socket = serverSocket.accept()

    Thread.sleep(1000000)
}

