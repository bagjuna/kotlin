package hello.tcp.exception.connect

import java.io.IOException
import java.net.Socket


fun main() {
    val socket = Socket("localhost", 12345)
    val input = socket.getInputStream()

    try {
        socket.setSoTimeout(3000) // 타임아웃 시간 설정
        val read = input.read()
        println("read = $read")
    } catch (e: Exception) {
        e.printStackTrace()
    }
    socket.close()
}
