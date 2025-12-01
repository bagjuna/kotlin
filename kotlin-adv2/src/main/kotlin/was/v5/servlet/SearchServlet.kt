package hello.was.v5.servlet

import hello.was.httpserver.HttpRequest
import hello.was.httpserver.HttpResponse
import hello.was.httpserver.HttpServlet

class SearchServlet : HttpServlet {

    override fun service(request: HttpRequest, response: HttpResponse) {
        val query = request.getParameter("q")

        response.writeBody("<h1>Search</h1>")
        response.writeBody("<ul>")
        response.writeBody("<li>query: $query</li>")
        response.writeBody("</ul>")
    }

}
