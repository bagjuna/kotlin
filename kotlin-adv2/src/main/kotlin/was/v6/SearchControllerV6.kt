package hello.was.v6

import hello.was.httpserver.HttpRequest
import hello.was.httpserver.HttpResponse

class SearchControllerV6 {

    fun search(request: HttpRequest, response: HttpResponse) {
        val query = request.getParameter("q")
        response.writeBody("<h1>Search</h1>")
        response.writeBody("<ul>")
        response.writeBody("<li>Query: $query</li>")
        response.writeBody("</ul>")
    }
}
