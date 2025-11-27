package hello.tcp

import hello.util.MyLogger.log
import java.io.Closeable
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.net.Socket


object SocketCloseUtil {

    // Closeable? 타입 하나로 퉁칠 수 있습니다.
    fun closeAll(vararg resources: Closeable?) {
        for (resource in resources) {
            close(resource)
        }
    }

    fun close(resource: Closeable?) {
        try {
            resource?.close() // null이 아니면 close() 실행
        } catch (e: Exception) {
            log(e.message) // 에러 나면 로그만 찍고 넘어감
        }
    }

//    companion object{
//        fun closeAll(socket: Socket?, input: InputStream?, output: OutputStream?) {
//            close(output)
//            close(input)
//            close(socket)
//        }
//
//        fun close(input: InputStream?) {
//            if (input != null) {
//                try {
//                    input.close()
//                } catch (e: IOException) {
//                    log(e.message)
//                }
//            }
//        }
//
//        fun close(output: OutputStream?) {
//            if (output != null) {
//                try {
//                    output.close()
//                } catch (e: IOException) {
//                    log(e.message)
//                }
//            }
//        }
//
//        fun close(socket: Socket?) {
//            if (socket != null) {
//                try {
//                    socket.close()
//                } catch (e: IOException) {
//                    log(e.message)
//                }
//            }
//        }
//    }




}
