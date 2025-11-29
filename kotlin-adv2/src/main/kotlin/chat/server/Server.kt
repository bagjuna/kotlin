package hello.chat.server

import hello.util.MyLogger.log
import java.io.IOException
import java.net.ServerSocket


class Server(
    val port: Int = 12345,
    val commandManager: CommandManager,
    val sessionManager: SessionManager = SessionManager(),
    private var serverSocket: ServerSocket? = null

){
    fun start() {
        val serverSocket = ServerSocket(port)
        println("서버 시작")

        // shutdown hook 등록
        addShutdownHook()
//        val target = ShutdownHook(serverSocket, sessionManager)
//        Runtime.getRuntime().addShutdownHook(Thread(target,"shutdownHook"))

        // 프로그램 작동
        running(serverSocket)
    }

    private fun running(serverSocket: ServerSocket) {
        try {
            while (true) {
                val socket = serverSocket.accept() // 블로킹
                println("소켓 연결: $socket")

                val session = Session(socket, sessionManager, commandManager)
                val thread = Thread(session)
                thread.start()
            }
        } catch (e: IOException) {
            println("서버 소켓 종료 $e")
        }
    }

    // 셧다운 훅 등록
    private fun addShutdownHook() {
        val target = ShutdownHook(serverSocket, sessionManager)
        Runtime.getRuntime().addShutdownHook(Thread(target, "shutdown"))
    }

    class ShutdownHook(
        private val serverSocket: ServerSocket?,
        private val sessionManager: SessionManager
    ) : Thread() {

        override fun run() {
            log("ShutdownHook 실행")
            try {
                sessionManager.closeAll()
                serverSocket?.close()

            } catch (e: Exception) {
                e.printStackTrace()
                println("e = $e")
            }
            log("Shutdown Hook finished")
        }
    }


}
