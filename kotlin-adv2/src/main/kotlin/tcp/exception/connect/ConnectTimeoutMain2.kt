package hello.tcp.exception.connect

import java.net.ConnectException
import java.net.InetSocketAddress
import java.net.Socket

fun main() {
    val start = System.currentTimeMillis()

    try {
        val socket = Socket()
        socket.connect(InetSocketAddress("192.168.1.250", 45678))
    }catch (e: ConnectException) {
        e.printStackTrace()
    }

    val end = System.currentTimeMillis()

    println("소요 시간: ${end - start} ms")
}
