package hello.io.buffered

import hello.io.buffered.BufferedConst.BUFFER_SIZE
import hello.io.buffered.BufferedConst.FILE_NAME
import hello.io.buffered.BufferedConst.FILE_SIZE
import java.io.BufferedOutputStream
import java.io.FileOutputStream

fun main() {
    val fos = FileOutputStream(FILE_NAME)
    val bos = BufferedOutputStream(fos, BUFFER_SIZE)

    val startTime = System.currentTimeMillis()

    for (i in 0 until FILE_SIZE) {
        bos.write(1)
    }

    bos.close()

    val endTime = System.currentTimeMillis()
    println("File created: ${FILE_SIZE}")
    println("File size: ${FILE_SIZE / 1024/1024} MB")
    println("Time taken: ${endTime - startTime} ms")

}
