package hello.was.v5

import hello.was.httpserver.HttpServer
import hello.was.httpserver.ServletManager
import hello.was.httpserver.servlet.DiscardServlet
import hello.was.v5.servlet.HomeServlet
import hello.was.v5.servlet.SearchServlet
import hello.was.v5.servlet.Site1Servlet
import hello.was.v5.servlet.Site2Servlet

fun main() {
    val PORT = 12345

    val servletManager = ServletManager()
    servletManager.add("/", HomeServlet())
    servletManager.add("/site1", Site1Servlet())
    servletManager.add("/site2", Site2Servlet())
    servletManager.add("/search", SearchServlet())
    servletManager.add("/favicon.ico", DiscardServlet())

    HttpServer(PORT, servletManager).start()



}
