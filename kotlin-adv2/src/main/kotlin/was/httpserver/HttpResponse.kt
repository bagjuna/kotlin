package hello.was.httpserver

import java.io.PrintWriter

class HttpResponse(
    private val writer: PrintWriter,
) {
    var statusCode = 200
    private val bodyBuilder = StringBuilder()
    private var contentType: String? = "text/html; charset=UTF-8"


    fun writeBody(body: String) {
        bodyBuilder.append(body)
    }


    fun flush() {
        val contentLength = bodyBuilder.toString().toByteArray().size
        writer.println("HTTP/1.1 $statusCode ${getResponsePhrase(statusCode)}")
        writer.println("Content-Type: $contentType")
        writer.println("Content-Length: $contentLength")
        writer.println()
        writer.println(bodyBuilder.toString())
        writer.flush()

    }

    fun getResponsePhrase(statusCode : Int
    ): String {
        return when(statusCode) {
            200 -> "OK"
            404 -> "Not Found"
            500 -> "Internal Server Error"
            else -> "Unknown Status"
        }
    }


}
