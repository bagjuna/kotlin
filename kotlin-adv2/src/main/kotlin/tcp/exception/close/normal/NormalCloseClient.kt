package hello.tcp.exception.close.normal

import hello.util.MyLogger.log
import java.io.BufferedReader
import java.io.DataInputStream
import java.io.EOFException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.Socket


fun main() {

    val socket = Socket("localhost", 12345)
    println("소켓 연결 $socket")
    val input = socket.inputStream

    readByInputStream(input, socket)
//    readByBufferedReader(input, socket)
//    readByDataInputStream(input, socket)

    log("연결 종료 ${socket.isClosed}")
}

fun readByInputStream(input: InputStream, socket: Socket) {
    val read = input.read()
    println("read = $read")
    if (read == -1) {
        input.close()
        socket.close()
    }
}

fun readByBufferedReader(input: InputStream, socket: Socket) {
    val br = BufferedReader(InputStreamReader(input))
    val readString = br.readLine()
    println("readString = $readString")
    if (readString == null) {
        br.close()
        socket.close()
    }
}

fun readByDataInputStream(input: InputStream, socket: Socket) {
    val dis = DataInputStream(input)
    try {
        dis.readUTF()
    }catch (e: EOFException) {
        log(e)
    }finally {
        dis.close()
        socket.close()
    }
}
