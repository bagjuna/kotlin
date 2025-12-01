package hello.was.httpserver.servlet

import hello.was.httpserver.HttpRequest
import hello.was.httpserver.HttpResponse
import hello.was.httpserver.HttpServlet

class InternalErrorServlet: HttpServlet {
    override fun service(request: HttpRequest, response: HttpResponse) {
        response.statusCode = 500
        response.writeBody("<h1>Internal Error</h1>")
    }
}
