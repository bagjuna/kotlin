package hello.was.v6

import hello.was.httpserver.HttpServer
import hello.was.httpserver.ServletManager
import hello.was.httpserver.servlet.DiscardServlet
import hello.was.httpserver.servlet.reflection.ReflectionServlet
import hello.was.v5.servlet.HomeServlet


fun main() {
    val PORT = 12345

    val controllers = listOf(SiteControllerV6(), SearchControllerV6())
    val reflectionServlet = ReflectionServlet(controllers)

    val servletManager = ServletManager()
    servletManager.setDefaultServlet(reflectionServlet)
    servletManager.add("/", HomeServlet())
    servletManager.add("/favicon.ico", DiscardServlet())


    val server = HttpServer(PORT, servletManager)
    server.start()

}
