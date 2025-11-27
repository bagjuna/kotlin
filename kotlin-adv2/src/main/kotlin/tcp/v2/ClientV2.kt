package hello.tcp.v2


import hello.util.MyLogger.log
import java.io.DataInputStream
import java.io.DataOutputStream
import java.net.Socket
import java.util.*

fun main() {
    val PORT = 12345
    log("클라이언트 시작")

    // Socket에 use를 걸면, 블록이 끝나거나 에러가 터져도 안전하게 close() 됩니다.
    Socket("localhost", PORT).use { socket ->
        log("서버에 연결: $socket")

        val input = DataInputStream(socket.getInputStream())
        val output = DataOutputStream(socket.getOutputStream())

        val scanner = Scanner(System.`in`)
        while (true) {
            print("전송 문자: ")
            val toSend = scanner.nextLine()
            output.writeUTF(toSend)
            log("client -> server: $toSend")

            if(toSend.lowercase() == "exit") {
                break
            }

            // 서버에서 문자 받기
            val received = input.readUTF()
            log("client <- server: $received")

        }

            log("연결 종료: $socket")
    } // 여기서 socket.close() 자동 호출됨
}
