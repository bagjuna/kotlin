package hello.tcp.v6

import hello.tcp.SocketCloseUtil.closeAll
import hello.util.MyLogger.log
import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.IOException
import java.net.Socket

class SessionV6(
    private val socket: Socket,
    private val sessionManager: SessionManagerV6,
) : Runnable {


    private val input: DataInputStream = DataInputStream(socket.getInputStream())
    private val output: DataOutputStream = DataOutputStream(socket.getOutputStream())
    private var closed: Boolean = false

    init {
        sessionManager.add(this)
    }

    override fun run() {
        try {
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

        } catch (e: IOException) {
            log(e)
        } finally {
            sessionManager.remove(this)
            close()
        }

    }

    // 새션 종료시, 서버 종료시 동시에 호출될 수 있다.
    @Synchronized
    fun close() {
        if (closed) {
            return
        }
        closeAll(socket, input, output)
        closed = true
        log("연결 종료: $socket is closed")
    }
}


