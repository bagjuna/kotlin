package hello.tcp.exception.close.reset

import hello.util.MyLogger.log
import java.net.Socket
import java.net.SocketException



fun main() {
    val socket = Socket("localhost", 12345)
    log("소켓 연결: $socket")
    val input = socket.inputStream
    val output = socket.outputStream


    // client <- server: FIN
    Thread.sleep(1000)  // 서버가 cloase() 호풀 할때 까지 잠시 대기

    // client -> server: PUSH[1]
    output.write(1)

    // client <- server: RST
    Thread.sleep(1000) // RST 메시지 전송 대기

    try {
        // java.net.SocketException: Connection reset
        val read = input.read()
        log("read = $read")
    } catch (e: Exception) {
        e.printStackTrace()
    }


    try {
        output.write(1)
    } catch (e: SocketException) {
        //java.net.SocketException: Broken pipe
        e.printStackTrace()
    }

}
