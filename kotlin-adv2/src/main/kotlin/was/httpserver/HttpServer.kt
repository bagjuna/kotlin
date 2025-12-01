package hello.was.httpserver

import java.net.ServerSocket
import java.util.concurrent.Executors

class HttpServer(

    private val port: Int,
    private val servletManager: ServletManager
) {

    private val es = Executors.newFixedThreadPool(10)

    fun start() {
        val serverSocket = ServerSocket(port)
        println("서버 시작 port: $port")

        while (true) {
            val socket = serverSocket.accept()
            es.submit { HttpRequestHandler(socket, servletManager).run()}
        }
    }


}
