package hello.was.v2

import hello.util.MyLogger.log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket
import kotlin.text.Charsets.UTF_8

class HttpRequestHandlerV2(private val socket: Socket) : Runnable {
    override fun run() {
        try {
            process()
        } catch (e: Exception) {
            log(e)
        }
    }
    private fun process() {
        socket.use {
            socket->
            val reader = socket.inputStream.bufferedReader(UTF_8)
            val writer = PrintWriter(socket.outputStream.writer(UTF_8))

            val requestToString = requestToString(reader)

            if(requestToString.contains("/favicon.ico")){
                log("favicon.ico 요청 무시")
                return
            }


            log("HTTP 요청 정보 출력")
            println(requestToString)

            log("HTTP 응답 생성중...")

            sleep(5000)
            responseToClient(writer)
            log("HTTP 응답 전달 완료")
        }
    }

    private fun requestToString(reader: BufferedReader):String {
        val sb = StringBuilder()
        var line: String?
        while ((reader.readLine().also { line = it }) != null) {
            if (line?.isEmpty() == true) {
                break
            }
            sb.append(line).append("\n")
        }
        return sb.toString()
    }

    private fun responseToClient(writer: PrintWriter) {
        // 웹 브라우저에 전달하는 내용

        val body = "<h1>Hello World</h1>"
        val length = body.toByteArray(UTF_8).size

        val response = buildString {
            append("HTTP/1.1 200 OK\r\n")
            append("Content-Type: text/html; charset=utf-8\r\n")
            append("Content-Length: $length\r\n")
            append("\r\n")
            append(body)
        }


        log("HTTP 응답 정보 출력")
        println(response)

        writer.println(response)
        writer.flush()
    }

    private fun sleep(millis: Int) {
        try {
            Thread.sleep(millis.toLong()) // 서버 처리 시간
        } catch (e: InterruptedException) {
            throw RuntimeException(e)
        }
    }

}
