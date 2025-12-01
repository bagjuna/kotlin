package hello.was.v5.servlet

import hello.was.httpserver.HttpRequest
import hello.was.httpserver.HttpResponse
import hello.was.httpserver.HttpServlet

class HomeServlet : HttpServlet {
    override fun service(request: HttpRequest, response: HttpResponse) {
        response.writeBody("<h1>home</h1>")
        response.writeBody("<ul>")
        response.writeBody("<li><a href=\"/site1\">site1</a></li>")
        response.writeBody("<li><a href=\"/site2\">site2</a></li>")
        response.writeBody("<li><a href=\"/search?q=hello\">검색</a></li>")
        response.writeBody("</ul>")
    }

}
