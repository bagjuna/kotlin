package hello.io.text

import hello.io.text.TextConst.FILE_NAME
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.text.Charsets.UTF_8

fun main() {
    val writeString = "ABC"
    println("write String: $writeString")


    // 파일에 쓰기
    val fos = FileOutputStream(FILE_NAME)
    val osw = OutputStreamWriter(fos, UTF_8)
    osw.write(writeString)
    osw.close()

//    OutputStreamWriter(fos, UTF_8).use { writer ->
//        writer.write(writeString)
//    }

    // 파일에서 읽기
//    val fis = FileInputStream(FILE_NAME)
//    InputStreamReader(fis, UTF_8).use { reader ->
//        val readString = reader.readText()
//        println("read String: $readString")
//    }
    
    val fis = FileInputStream(FILE_NAME)
    val isr = InputStreamReader(fis, UTF_8)
    val content = StringBuilder()
    var ch : Int
    while(isr.read().also { ch = it } != -1){
        content.append(ch.toChar())
    }
    isr.close()

    val readString = content.toString()
    println("read String: $readString")
}
