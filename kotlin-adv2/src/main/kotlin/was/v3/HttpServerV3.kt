package hello.was.v3

import hello.was.v2.HttpRequestHandlerV2
import java.net.ServerSocket
import java.util.concurrent.Executors

class HttpServerV3(

    private val port: Int
) {

    private val es = Executors.newFixedThreadPool(10)

    fun start() {
        val serverSocket = ServerSocket(port)
        println("서버 시작 port: $port")

        while (true) {
            val socket = serverSocket.accept()
            es.submit { HttpRequestHandlerV3(socket).run()}
        }
    }


}
