package hello.io.start

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream

fun main() {
    val input = byteArrayOf(1, 2, 3)

    // 메모리에 쓰기
    val baos = ByteArrayOutputStream()
    baos.write(input)

    // 메모리에서 읽기
    val bais = ByteArrayInputStream(baos.toByteArray())
    val bytes = bais.readAllBytes()
    println(bytes.contentToString())
}
