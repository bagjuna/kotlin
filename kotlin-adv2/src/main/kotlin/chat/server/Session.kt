package hello.chat.server

import hello.tcp.SocketCloseUtil
import hello.util.MyLogger.log
import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.IOException
import java.net.Socket

class Session(
    private val socket: Socket,
    private val sessionManager: SessionManager,
    private val commandManager: CommandManager,


) : Runnable {

    private var closed: Boolean = false
    var username: String = "익명"
    private val input: DataInputStream = DataInputStream(socket.getInputStream())
    private val output: DataOutputStream = DataOutputStream(socket.getOutputStream())

    init {
        sessionManager.add(this)
    }

    override fun run() {
        try {
            while (true) {
                // 클라이언트로부터 문자 받기
                val received = input.readUTF()

                // 클라이언트로부터 문자 보내기
                commandManager.execute(received, this)
            }

        } catch (e: IOException) {
            log(e)
        } finally {
            sessionManager.remove(this)
            sessionManager.sendAll(username + "님이 퇴장했습니다.");
            close()
        }

    }

    // 새션 종료시, 서버 종료시 동시에 호출될 수 있다.
    @Synchronized
    fun close() {
        if (closed) {
            return
        }
        SocketCloseUtil.closeAll(socket, input, output)
        closed = true
        log("연결 종료: $socket")
    }

    fun send(totalMessage: String?) {
        output.writeUTF(totalMessage ?: "")
    }


}
