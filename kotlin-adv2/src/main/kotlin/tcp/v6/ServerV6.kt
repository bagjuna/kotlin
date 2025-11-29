package hello.tcp.v6

import hello.util.MyLogger.log
import java.io.IOException
import java.net.ServerSocket

fun main() {
    val PORT = 12345
    log("서버 시작")
    val sessionManager = SessionManagerV6()
    val serverSocket = ServerSocket(PORT)


    // shutdown hook 등록
    val shutdownHook = ShutdownHookV6(serverSocket, sessionManager)
    Runtime.getRuntime().addShutdownHook(Thread(shutdownHook,"shutdownHook"))

    try {
        while (true) {
            val socket = serverSocket.accept() // 블로킹
            log("소켓 연결: $socket")

            val session = SessionV6(socket, sessionManager)
            val thread = Thread(session)
            thread.start()
        }
    } catch (e: IOException) {
        log("서버 소켓 종료 $e")
    }


}

class ShutdownHookV6(
    private val serverSocket: ServerSocket,
    private val sessionManager: SessionManagerV6
) : Thread() {

    override fun run() {
        log("Shutdown Hook started")
        try {
            sessionManager.closeAll()
            serverSocket.close()

        } catch (e: Exception) {
            e.printStackTrace()
            println("e = $e")
        }
        log("Shutdown Hook finished")
    }
}
