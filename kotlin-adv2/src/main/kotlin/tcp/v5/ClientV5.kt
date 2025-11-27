package hello.tcp.v5


import hello.util.MyLogger.log
import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.IOException
import java.net.Socket
import java.util.*

fun main() {

    val PORT = 12345
    log("클라이언트 시작")


    Socket("localhost", PORT).use { socket ->
        log("서버에 연결: $socket")
        DataInputStream(socket.getInputStream()).use { input ->
            DataOutputStream(socket.getOutputStream()).use { output ->
                val scanner = Scanner(System.`in`)
                while (true) {
                    print("전송 문자: ")
                    val toSend = scanner.nextLine()
                    output.writeUTF(toSend)
                    log("client -> server: $toSend")

                    if (toSend.lowercase() == "exit") {
                        break
                    }

                    // 서버에서 문자 받기
                    val received = input.readUTF()
                    log("client <- server: $received")
                }
            }
        }

    }

}
