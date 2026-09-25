package hello.was.httpserver.servlet.reflection

import hello.was.httpserver.HttpRequest
import hello.was.httpserver.HttpResponse
import hello.was.httpserver.HttpServlet
import hello.was.httpserver.PageNotFoundException
import kotlin.reflect.KFunction
import kotlin.reflect.full.declaredFunctions

class ReflectionServlet(
    private val controllers: List<Any>
) : HttpServlet {



    override fun service(request: HttpRequest, response: HttpResponse) {
        val path = request.path   // request.getPath()와 동일

        // siteControllerV6, searchControllerV6
        for (controller in controllers) {
            val klass = controller::class
            val functions = klass.declaredFunctions
            for (function in functions) {
                val functionName = function.name
                if (path == "/$functionName") {
                    invoke(controller, function, request, response)
                    return
                }
            }
        }
        throw PageNotFoundException("404 Not Found: $path")
    }

    private fun invoke(
        controller: Any, function: KFunction<*>, request: HttpRequest, response: HttpResponse) {
        try {
            // invoke 대신 call 사용
            function.call(controller, request, response)
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}
