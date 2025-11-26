package hello.io.file

import java.io.File


fun main() {
    val file = File("temp/..")
    println("path = " + file.path)

    // 절대 경로
    println("Absolute Path = " + file.absolutePath)
    // 정규 경로
    println("Canonical path = " + file.canonicalPath)


}
