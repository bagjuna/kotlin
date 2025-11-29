package hello.chat.client

import hello.util.MyLogger.log
import java.io.DataInputStream
import java.io.IOException

class ReadHandler(
    val input: DataInputStream,
    val client: Client
): Runnable {
    var closed: Boolean = false

    override fun run() {
        try {
            while (true) {
                val received = input.readUTF()
                println(received)

            }
        } catch (e: IOException) {
            log(e)
        } finally {
            client.close()
        }

    }




    @Synchronized
    fun close() {
        if (closed) {
            return
        }
        closed = true
        log("read handler closed")
    }

}
