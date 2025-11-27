package hello.tcp.v3

import hello.util.MyLogger.log
import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.IOException
import java.net.Socket


class SessionV3(private val socket: Socket): Runnable{

    override fun run() {
        try {
            val input = DataInputStream(socket.getInputStream())
            val output = DataOutputStream(socket.getOutputStream())

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

            // 자원 정리
            log("연결 종료: $socket")
            input.close()
            output.close()
            socket.close()
        }catch (e: IOException){
            throw RuntimeException(e)
        }
    }

}
