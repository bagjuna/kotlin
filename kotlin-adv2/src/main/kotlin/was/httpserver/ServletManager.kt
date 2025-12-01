package hello.was.httpserver

import hello.was.httpserver.servlet.InternalErrorServlet
import hello.was.httpserver.servlet.NotFoundServlet

class ServletManager {
    val servletMap: MutableMap<String, HttpServlet> = mutableMapOf()
    private var defaultServlet: HttpServlet? = null
    val notFoundErrorServlet = NotFoundServlet()
    val internalErrorServlet = InternalErrorServlet()

    fun setDefaultServlet(servlet: HttpServlet) {
        this.defaultServlet = servlet
    }


    fun add(path: String, servlet: HttpServlet) {
        servletMap[path] = servlet

    }

    fun execute(request: HttpRequest, response: HttpResponse) {
        try {
            val servlet = servletMap[request.path] ?: defaultServlet
            if (servlet == null) {
                throw PageNotFoundException("request url: ${request.path}")
            }
            servlet.service(request, response)
        } catch (e: PageNotFoundException) {
            notFoundErrorServlet.service(request, response)
        } catch (e: Exception) {
            internalErrorServlet.service(request, response)
        }


    }

}
