package hello.io.file

import java.nio.file.Files
import java.nio.file.Path

fun main() {
    val path = Path.of("temp/..")

    println("path = $path")

    // 절대 경로
    println("Absolute Path = " + path.toAbsolutePath())
    // 정규 경로
    println("Canonical path = " + path.toRealPath())

    val pathStream = Files.list(path)
    val list = pathStream.toList()

    for (p in list) {
        println((if (Files.isRegularFile(p)) "F" else "D") + " | " + p.fileName)
    }
}
