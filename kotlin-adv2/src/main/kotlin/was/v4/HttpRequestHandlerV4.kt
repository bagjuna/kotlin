package hello.was.v4

import hello.util.MyLogger
import hello.was.httpserver.HttpRequest
import hello.was.httpserver.HttpResponse
import java.io.BufferedReader
import java.io.PrintWriter
import java.net.Socket
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

class HttpRequestHandlerV4(private val socket: Socket) : Runnable {
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


            if (request.path.equals("/favicon.ico")) {
                MyLogger.log("favicon.ico 요청 무시")
                return
            }
            MyLogger.log("HTTP 요청 정보 출력")
            println(request)

            if (request.path.startsWith("/site1")) {
                site1(response)
            } else if (request.path.startsWith("/site2")) {
                site2(response)
            } else if (request.path.startsWith("/search")) {
                search(request,response)
            }else if (request.path.startsWith("/")) {
                home(response)
            }else{
                notFound(response)
            }
            response.flush()

            MyLogger.log("HTTP 응답 전달 완료")

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


    private fun home(response: HttpResponse) {

        response.writeBody("<h1>home</h1>")
        response.writeBody("<ul>")
        response.writeBody("<li><a href=\"/site1\">site1</a></li>")
        response.writeBody("<li><a href=\"/site2\">site2</a></li>")
        response.writeBody("<li><a href=\"/search?q=hello\">검색</a></li>")
        response.writeBody("</ul>")
    }

    private fun site1(response: HttpResponse) {
        response.writeBody("<h1>site1</h1>")
    }

    private fun site2(response: HttpResponse) {
        response.writeBody("<h1>site2</h1>")
    }

    private fun notFound(response: HttpResponse) {
        response.writeBody("<h1>404 페이지를 찾을 수 없습니다.</h1>")
    }

    // "/search?q=hello" 처럼 쿼리 파라미터를 처리
    private fun search(request: HttpRequest, response: HttpResponse) {

        val query = request.getParameter("q")
        // 쿼리 파라미터 추출
//

        response.writeBody("<h1>Search</h1>")
        response.writeBody("<ul>")
        response.writeBody("<li>query: $query</li>")
        response.writeBody("</ul>")

    }
}
