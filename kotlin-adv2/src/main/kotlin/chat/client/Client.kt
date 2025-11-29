package hello.chat.client


import hello.tcp.SocketCloseUtil.closeAll
import hello.util.MyLogger.log
import java.io.DataInputStream
import java.io.DataOutputStream
import java.net.Socket


class Client(
    private val host: String,
    private val port: Int,
) {
    val socket = Socket(host, port)
    val input = DataInputStream(socket.getInputStream())
    val output = DataOutputStream(socket.getOutputStream())
    var readHandler = ReadHandler(input, this)
    var writeHandler = WriteHandler(output, this)
    var closed = false

    fun start() {
        log("클라이언트 시작")
        val readHandler = Thread(readHandler, "readHandler")
        val writeHandler = Thread(writeHandler, "writeHandler")
        readHandler.start()
        writeHandler.start()
    }

    @Synchronized
    fun close() {
        if (closed) {
            return
        }
        readHandler?.close()
        writeHandler?.close()
        closeAll(socket, input, output)
        closed = true
        log("client closed")

    }

}
