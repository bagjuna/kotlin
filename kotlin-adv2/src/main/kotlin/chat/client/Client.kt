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
    private lateinit var socket: Socket
    private lateinit var input: DataInputStream
    private lateinit var output: DataOutputStream
    private lateinit var readHandler: ReadHandler
//    var writeHandler = WriteHandler(output, this)
    private lateinit var writeHandler: WriteHandler
    var closed = false

    fun start() {
        log("클라이언트 시작")
        socket = Socket(host, port)
        input = DataInputStream(socket.getInputStream())
        output = DataOutputStream(socket.getOutputStream())

        readHandler = ReadHandler(input, this)
        writeHandler = WriteHandler(output, this)
        Thread(readHandler).start()
        Thread(writeHandler).start()
//        readHandler.start()
//        writeHandler.start()
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
