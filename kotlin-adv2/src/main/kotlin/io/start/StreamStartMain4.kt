package hello.io.start

import java.io.FileInputStream
import java.io.FileOutputStream


fun main(){

    val fos = FileOutputStream("src/main/kotlin/temp/hello.dat")

    val input = byteArrayOf(65, 66, 67)
    fos.write(input)
    fos.close()

    val fis = FileInputStream("src/main/kotlin/temp/hello.dat")
    val readAllBytes = fis.readAllBytes()

    println("읽은 바이트 수: ${readAllBytes.size}")

    println(readAllBytes.contentToString())


    fis.close()


}
