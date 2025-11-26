package hello.io.file.text.copy

import java.nio.file.Path

fun main() {
    val startTime = System.currentTimeMillis()

    val source = Path.of("temp/copy.dat")

    val endTime = System.currentTimeMillis()
    println("Time taken: ${endTime - startTime} ms")

}
