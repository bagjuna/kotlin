package hello.was.v1

import hello.util.MyLogger.log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket
import java.net.Socket
import kotlin.text.Charsets.UTF_8

class HttpServerV1(private val port: Int) {

    fun start() {
        val serverSocket = ServerSocket(port)
        log("서버 시작 port: $port")

        while (true) {
            val socket = serverSocket.accept()
            process(socket)
        }
    }

    private fun process(socket: Socket) {
        socket.use {socket->
            val reader: BufferedReader = BufferedReader(InputStreamReader(socket.getInputStream(), UTF_8))
            val writer: PrintWriter = PrintWriter(socket.getOutputStream(), false, UTF_8)

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

        val sb = StringBuilder()
        sb.append("HTTP/1.1 200 OK\r\n")
        sb.append("Content-Type: text/html; charset=utf-8\r\n")
        sb.append("Content-Length: $length\r\n")
        sb.append("\r\n") // header 와 body 구분
        sb.append(body)


        log("HTTP 응답 정보 출력")
        println(sb)

        writer.println(sb)
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

