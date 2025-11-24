package hello.io.start

import java.nio.charset.StandardCharsets

fun main() {

    val printStream = System.out

    val bytes = "Hello!\n".toByteArray(StandardCharsets.UTF_8)
    printStream.write(bytes)
    printStream.println("Print!")


}
