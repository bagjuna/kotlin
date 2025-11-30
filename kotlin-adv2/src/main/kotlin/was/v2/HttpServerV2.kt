package hello.was.v2

import java.net.ServerSocket
import java.util.concurrent.Executors

class HttpServerV2(

    private val port: Int
) {

    private val es = Executors.newFixedThreadPool(10)

    fun start() {
        val serverSocket = ServerSocket(port)
        println("서버 시작 port: $port")

        while (true) {
            val socket = serverSocket.accept()
            es.submit { HttpRequestHandlerV2(socket).run()}
        }
    }


}
