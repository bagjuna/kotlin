package hello.io.start

import java.io.FileInputStream
import java.io.FileOutputStream


fun main(){

    val fos = FileOutputStream("temp/hello.dat")

    val input = byteArrayOf(65, 66, 67)
    fos.write(input)
    fos.close()

    val fis = FileInputStream("temp/hello.dat")

    val buffer = ByteArray(10)
    val readBytes = fis.read(buffer, 0, 10) // 최대 10바이트 읽기
    println("읽은 바이트 수: $readBytes")

    println(buffer.contentToString())


    fis.close()


}
