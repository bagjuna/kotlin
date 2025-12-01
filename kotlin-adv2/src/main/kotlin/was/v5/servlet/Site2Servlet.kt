package hello.was.v5.servlet

import hello.was.httpserver.HttpRequest
import hello.was.httpserver.HttpResponse
import hello.was.httpserver.HttpServlet

class Site2Servlet: HttpServlet {
    override fun service(request: HttpRequest, response: HttpResponse) {
        response.writeBody("<h1>site2</h1>")

    }

}
