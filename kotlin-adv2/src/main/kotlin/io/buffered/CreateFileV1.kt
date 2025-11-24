package hello.io.buffered

import hello.io.buffered.BufferedConst.FILE_NAME
import hello.io.buffered.BufferedConst.FILE_SIZE
import java.io.FileOutputStream

fun main() {
    val fos = FileOutputStream(FILE_NAME)

    val startTime = System.currentTimeMillis()

    for (i in 0 until FILE_SIZE) {
        fos.write(1)
    }


    fos.close()

    val endTime = System.currentTimeMillis()
    println("File created: ${FILE_SIZE}")
    println("File size: ${FILE_SIZE / 1024/1024} MB")
    println("Time taken: ${endTime - startTime} ms")

}
