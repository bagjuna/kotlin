package hello.was.v6

import hello.was.httpserver.HttpRequest
import hello.was.httpserver.HttpResponse

class SiteControllerV6 {

    fun site1(request: HttpRequest, response: HttpResponse) {
        response.writeBody("<h1>site1</h1>")
    }

    fun site2(request: HttpRequest, response: HttpResponse) {
        response.writeBody("<h1>site2</h1>")
    }
}
