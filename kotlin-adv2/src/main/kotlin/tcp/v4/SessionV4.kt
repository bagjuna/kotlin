package hello.tcp.v4


import hello.tcp.SocketCloseUtil.closeAll
import hello.util.MyLogger.log
import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.IOException
import java.net.Socket

class SessionV4(private val socket: Socket): Runnable{

    var input: DataInputStream? = null
    var output: DataOutputStream? = null

    override fun run() {
        try {
            input = DataInputStream(socket.getInputStream())
            output = DataOutputStream(socket.getOutputStream())

            while (true) {
                // 클라이언트로부터 문자 받기

                val received = input?.readUTF()
                log("client -> server: $received")

                if (received == "exit") {
                    break
                }

                // 클라이언트로부터 문자 보내기
                val toSend = "$received World!"
                output?.writeUTF(toSend)
                log("client <- server: $toSend")
            }

        }catch (e: IOException){
            log(e)
        }
        finally {
            closeAll(socket, input, output)
            log("연결 종료: $socket")
        }
    }

}
