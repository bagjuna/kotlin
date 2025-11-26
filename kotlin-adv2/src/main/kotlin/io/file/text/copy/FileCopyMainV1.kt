package hello.io.file.text.copy

import java.io.FileInputStream
import java.io.FileOutputStream

fun main() {
    val startTime = System.currentTimeMillis()

    val fis = FileInputStream("temp/copy.dat")
    val fos = FileOutputStream("temp/copy_copy.dat")

    val bytes = fis.readAllBytes()
    fos.write(bytes)


    fis.close()
    fos.close()

    val endTime = System.currentTimeMillis()
    println("Time taken: ${endTime - startTime} ms")

}
