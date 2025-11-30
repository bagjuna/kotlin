package hello.was.v3

import hello.util.MyLogger.log
import java.io.BufferedReader
import java.io.PrintWriter
import java.net.Socket
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

class HttpRequestHandlerV3(private val socket: Socket) : Runnable {
    override fun run() {
        try {
            process()
        } catch (e: Exception) {
            log(e)
        }
    }

    private fun process() {
        socket.use { socket ->
            val reader = socket.inputStream.bufferedReader(Charsets.UTF_8)
            val writer = PrintWriter(socket.outputStream.writer(Charsets.UTF_8))

            val requestToString = requestToString(reader)

            if (requestToString.contains("/favicon.ico")) {
                log("favicon.ico 요청 무시")
                return
            }
            log("HTTP 요청 정보 출력")
            println(requestToString)

            if (requestToString.startsWith("GET /site1")) {
                site1(writer)
            } else if (requestToString.startsWith("GET /site2")) {
                site2(writer)
            } else if (requestToString.startsWith("GET /search")) {
                search(writer,requestToString)
            }else if (requestToString.startsWith("GET / ")) {
                home(writer)
            }else{
                notFound(writer)
            }


            log("HTTP 응답 전달 완료")

        }
    }

    private fun requestToString(reader: BufferedReader): String {
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


    private fun home(writer: PrintWriter) {

        // 원칙적으로는 Content-Length를 계산해서 보내야 하지만 여기서는 생략
        writer.println("HTTP/1.1 200 OK")
        writer.println("Content-Type: text/html; charset=utf-8")
        writer.println()
        writer.println("<h1>home</h1>")
        writer.println("<ul>")
        writer.println("<li><a href=\"/site1\">site1</a></li>")
        writer.println("<li><a href=\"/site2\">site2</a></li>")
        writer.println("<li><a href=\"/search?q=hello\">검색</a></li>")
        writer.println("</ul>")
        writer.flush()
    }

    private fun site1(writer: PrintWriter) {
        writer.println("HTTP/1.1 200 OK")
        writer.println("Content-Type: text/html; charset=utf-8")
        writer.println()
        writer.println("<h1>site1</h1>")
        writer.flush()
    }

    private fun site2(writer: PrintWriter) {
        writer.println("HTTP/1.1 200 OK")
        writer.println("Content-Type: text/html; charset=utf-8")
        writer.println()
        writer.println("<h1>site2</h1>")
        writer.flush()
    }

    // "/search?q=hello" 처럼 쿼리 파라미터를 처리
    private fun search(writer: PrintWriter,requestString : String = "") {
        // 쿼리 파라미터 추출
//        val startIndex = requestString.indexOf("q=")
//        val endIndex = requestString.indexOf(" ", startIndex + 2)
//        val query = requestString.substring(startIndex + 2, endIndex)
//        val decode = URLDecoder.decode(query, UTF_8)
//
        val startIndex = requestString.indexOf("q=")
        val endIndex = requestString.indexOf(" ", startIndex + 2)
        val query = requestString.substring(startIndex + 2, endIndex)
        val decode = URLDecoder.decode(query, StandardCharsets.UTF_8)

        writer.println("HTTP/1.1 200 OK")
        writer.println("Content-Type: text/html; charset=utf-8")
        writer.println()
        writer.println("<h1>Search</h1>")
        writer.println("<ul>")
        writer.println("<li>query: $query</li>")
        writer.println("<li>decode: $decode</li>")
        writer.println("</ul>")
        writer.flush()
    }
    private fun notFound(writer: PrintWriter) {
        writer.println("HTTP/1.1 404 Not Found")
        writer.println("Content-Type: text/html; charset=utf-8")
        writer.println()
        writer.println("<h1>404 페이지를 찾을 수 없습니다.</h1>")
        writer.flush()
    }
}
