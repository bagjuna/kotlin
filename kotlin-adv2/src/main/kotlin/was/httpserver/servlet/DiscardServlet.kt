package hello.was.httpserver.servlet

import hello.was.httpserver.HttpRequest
import hello.was.httpserver.HttpResponse
import hello.was.httpserver.HttpServlet

class DiscardServlet: HttpServlet {
    override fun service(request: HttpRequest, response: HttpResponse) {
        // empty
    }
}
