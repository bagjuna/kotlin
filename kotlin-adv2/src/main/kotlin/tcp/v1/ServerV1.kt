package hello.tcp.v1

import hello.util.MyLogger.log
import java.io.DataInputStream
import java.io.DataOutputStream
import java.net.ServerSocket
import java.net.Socket

fun main() {

    val PORT = 12345
    log("서버 시작")

    val serverSocket = ServerSocket(PORT)

    log("서버 소켓 시작 - 리스팅 포트: $PORT")

    serverSocket.accept().use { socket ->
        log("소켓 연결: $socket")


        val input = DataInputStream(socket.inputStream)
        val output = DataOutputStream(socket.outputStream)

        // 클라이언트로부터 문자 받기
        val received: String = input.readUTF()
        log("client -> server: $received")


        // 클라이언트로부터 문자 보내기
        val toSend = "$received World!"
        output.writeUTF(toSend)
        log("client <- server: $toSend")

        // 자원 정리
        log("연결 종료: $socket")
        input.close()
        output.close()
    }

    serverSocket.close()


}
