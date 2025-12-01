package hello.was.httpserver.servlet

import hello.was.httpserver.HttpRequest
import hello.was.httpserver.HttpResponse
import hello.was.httpserver.HttpServlet

class NotFoundServlet: HttpServlet {
    override fun service(request: HttpRequest, response: HttpResponse) {
        response.statusCode = 404
        response.writeBody("<h1>404 페이지를 찾을 수 없습니다.</h1>")
    }


}
