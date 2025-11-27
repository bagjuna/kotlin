package hello.tcp.v1

import java.net.InetAddress
import java.net.UnknownHostException


fun main() {
    val localhost = InetAddress.getByName("localhost")
    println(localhost)

    val google = InetAddress.getByName("google.com")
    println(google)
}
