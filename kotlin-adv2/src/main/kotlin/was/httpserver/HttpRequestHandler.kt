package hello.was.httpserver

import hello.util.MyLogger
import hello.util.MyLogger.log
import java.io.BufferedReader
import java.io.PrintWriter
import java.net.Socket

class HttpRequestHandler(
    private val socket: Socket,
    private val servletManager: ServletManager
) : Runnable {

    override fun run() {
        try {
            process()
        } catch (e: Exception) {
            MyLogger.log(e)
        }
    }

    private fun process() {
        socket.use { socket ->
            val reader = socket.inputStream.bufferedReader(Charsets.UTF_8)
            val writer = PrintWriter(socket.outputStream.writer(Charsets.UTF_8))

            val request = HttpRequest(reader)
            val response = HttpResponse(writer)

            log("HTTP 요청: $request")
            servletManager.execute(request, response)
            response.flush()
            log("HTTP 응답 완료")

        }
    }


}
