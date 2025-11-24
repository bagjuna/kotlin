package hello.io.buffered

import hello.io.buffered.BufferedConst.FILE_NAME
import hello.io.buffered.BufferedConst.FILE_SIZE
import java.io.FileInputStream

fun main() {
    val fis = FileInputStream(FILE_NAME)
    val startTime = System.currentTimeMillis()

    val bytes = fis.readAllBytes()


    fis.close()

    var endTime = System.currentTimeMillis()

    println("File name: $FILE_NAME")
    println("File size: ${bytes.size / 1024 / 1024} MB") // 계산된 변수(fileSize)를 출력해야 함
    println("Time taken: ${endTime - startTime} ms")
}
