package hello.io.buffered

import hello.io.buffered.BufferedConst.BUFFER_SIZE
import hello.io.buffered.BufferedConst.FILE_NAME
import hello.io.buffered.BufferedConst.FILE_SIZE
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.FileInputStream

fun main() {
    val fis = FileInputStream(FILE_NAME)
    val bis = BufferedInputStream(fis, BUFFER_SIZE)
    val startTime = System.currentTimeMillis()

    var fileSize = 0
    var data : Int
    while(bis.read().also { data = it } != -1){
        fileSize++
    }

    bis.close()

    var endTime = System.currentTimeMillis()

    println(fileSize)
    println("File name: $FILE_NAME")
    println("File size: ${fileSize / 1024 / 1024} MB") // 계산된 변수(fileSize)를 출력해야 함
    println("Time taken: ${endTime - startTime} ms")
}
