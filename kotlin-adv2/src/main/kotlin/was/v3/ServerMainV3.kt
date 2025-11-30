package hello.was.v3

import hello.was.v2.HttpServerV2

fun main() {
    val PORT = 12345
    HttpServerV3(PORT).start()

}
