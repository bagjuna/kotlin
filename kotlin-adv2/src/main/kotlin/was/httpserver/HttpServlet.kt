package hello.was.httpserver

interface HttpServlet {
    fun service(request: HttpRequest, response: HttpResponse)

}
