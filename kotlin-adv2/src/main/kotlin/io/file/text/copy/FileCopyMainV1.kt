package hello.io.file.text.copy

import java.io.FileInputStream
import java.io.FileOutputStream

fun main() {
    val startTime = System.currentTimeMillis()

    val fis = FileInputStream("src/main/kotlin/temp/copy.dat")
    val fos = FileOutputStream("src/main/kotlin/temp/copy_copy.dat")

    val bytes = fis.readAllBytes()
    fos.write(bytes)


    fis.close()
    fos.close()

    val endTime = System.currentTimeMillis()
    println("Time taken: ${endTime - startTime} ms")

}
