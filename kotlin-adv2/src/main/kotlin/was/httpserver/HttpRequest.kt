package hello.was.httpserver

import java.io.BufferedReader
import java.io.IOException
import java.net.URLDecoder
import java.nio.charset.StandardCharsets.UTF_8

class HttpRequest(
    reader: BufferedReader
) {
    var method: String = ""
    var path: String = ""
    var statusCode = 200 // private 제거 또는 set 메서드 추가
    // q=hello&key2=value298
    val queryParameters = mutableMapOf<String, String>()
    val headers = mutableMapOf<String, String>()

    init {
        parseRequestLine(reader)
        parseHeaders(reader)
    }

    // GET /search?q=hello HTTP/1.1
    // Host: localhost:12345
    private fun parseRequestLine(reader: BufferedReader) {
        val requestLine = reader.readLine() ?: throw IOException("EOF: No request line received")

        val parts = requestLine.split(" ")
        if (parts.size < 3) {
            throw IOException("잘못된 요청 라인입니다: $requestLine")
        }

        method = parts[0]
        val pathParts = parts[1].split("?")
        path = pathParts[0]

        // q=hello
        // key1=value1&key2=value2
        if (pathParts.size > 1) {
            parseQueryParameters(pathParts[1])
        }


    }


    private fun parseQueryParameters(queryString: String) {
        for (param in queryString.split("&")) {
            val keyValue = param.split("=")
            val key = URLDecoder.decode(keyValue.first(), UTF_8)
            val value = if (keyValue.size > 1) URLDecoder.decode(keyValue[1], UTF_8) else ""
            queryParameters[key] = value
        }
    }

    private fun parseHeaders(reader: BufferedReader) {
        var line: String?
        while (!(reader.readLine().also { line = it }).isEmpty()) {
            // val headerParts = line!!.split(":").toMutableList()
            // headers[headerParts[0]] = headerParts[1].trim()
            val headerParts = line!!.split(":", limit = 2)
            if (headerParts.size == 2) {
                headers[headerParts[0].trim()] = headerParts[1].trim()
            }
        }
    }

    fun getParameter(name: String?): String? {
        return queryParameters[name]
    }

    override fun toString(): String {
        return "HttpRequest{" +
                "method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", queryParameters=" + queryParameters +
                ", headers=" + headers +
                '}'
    }
}


