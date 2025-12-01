package hello.was.v4

import java.net.ServerSocket
import java.util.concurrent.Executors

class HttpServerV4(

    private val port: Int
) {

    private val es = Executors.newFixedThreadPool(10)

    fun start() {
        val serverSocket = ServerSocket(port)
        println("서버 시작 port: $port")

        while (true) {
            val socket = serverSocket.accept()
            es.submit { HttpRequestHandlerV4(socket).run()}
        }
    }


}
