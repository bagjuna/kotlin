package tcp.v4


import hello.tcp.SocketCloseUtil.closeAll
import hello.util.MyLogger.log
import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.IOException
import java.net.Socket
import java.util.*

fun main() {

    val PORT = 12345
    log("클라이언트 시작")

    // finally 블록에서 변수에 접근해야 한다. 따라서 try 블록 밖에서 선언 해야야 한다.
    var socket: Socket? = null
    var input: DataInputStream? = null

    var output: DataOutputStream? = null

    try {
        socket = Socket("localhost", PORT)
        input = DataInputStream(socket.getInputStream())
        output = DataOutputStream(socket.getOutputStream())
        log("소캣 연결: $socket")

        val scanner = Scanner(System.`in`)
        while (true) {
            print("전송 문자: ")
            val toSend = scanner.nextLine()

            // 서버에서 문자 보내기
            output.writeUTF(toSend)
            log("client -> server: $toSend")

            if (toSend == "exit") {
                break
            }

            // 서버로부터 문자 받기
            val received = input.readUTF()
            log("client <- server: $received")
        }
    } catch (e: IOException) {
        log(e)
    } finally {
        closeAll(socket, input, output)
        log("연결 종료: $socket")
    }


}
