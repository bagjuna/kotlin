package hello.tcp.exception.connect

import java.net.ConnectException
import java.net.Socket
import java.net.UnknownHostException

fun main() {
//    unknownHostException1()
//    unknownHostException2()
    connectRefused()
}

fun unknownHostException1() {
    try {
        val socket = Socket("999.999.999.999", 80)
    } catch (e: UnknownHostException) {
        e.printStackTrace()
    }
}

fun unknownHostException2() {
    try {
        val socket = Socket("no-such-hostname", 80)
    } catch (e: UnknownHostException) {
        e.printStackTrace()
    }
}

fun connectRefused() {
    try {
        val socket = Socket("localhost", 45678)
    }catch (e: ConnectException) {
        e.printStackTrace()
    }

}
