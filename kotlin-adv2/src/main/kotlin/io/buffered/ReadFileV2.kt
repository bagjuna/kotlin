package hello.io.buffered

import hello.io.buffered.BufferedConst.BUFFER_SIZE
import hello.io.buffered.BufferedConst.FILE_NAME
import java.io.FileInputStream

fun main() {
    val fis = FileInputStream(FILE_NAME)
    val startTime = System.currentTimeMillis()

    val buffer = ByteArray(BUFFER_SIZE)
    var fileSize = 0
    var size : Int
    while(fis.read(buffer).also { size = it } != -1){
        fileSize += size
    }



    fis.close()

    var endTime = System.currentTimeMillis()

    println(fileSize)
    println("File name: $FILE_NAME")
    println("File size: ${fileSize / 1024 / 1024} MB") // 계산된 변수(fileSize)를 출력해야 함
    println("Time taken: ${endTime - startTime} ms")
}
