package hello.tcp.v5

import hello.util.MyLogger.log
import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.IOException
import java.net.Socket

class SessionV5(private val socket: Socket) : Runnable {


    override fun run() {
        socket.use { socket ->
            try {
                DataInputStream(socket.getInputStream()).use { input ->
                    DataOutputStream(socket.getOutputStream()).use { output ->

                        while (true) {
                            // 클라이언트로부터 문자 받기

                            val received = input.readUTF()
                            log("client -> server: $received")

                            if (received == "exit") {
                                break
                            }

                            // 클라이언트로부터 문자 보내기
                            val toSend = "$received World!"
                            output.writeUTF(toSend)
                            log("client <- server: $toSend")
                        }
                    }
                }

            } catch (e: IOException) {
                log(e)
            }
        }
        log("연결 종료: $socket is closed=${socket.isClosed}")


    }
}
