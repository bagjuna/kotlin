package hello.io.text

import hello.io.text.TextConst.FILE_NAME
import java.io.FileReader
import java.io.FileWriter

fun main() {

    val writeString = "abc"
    println("write String: $writeString")

    // 파일에 쓰기
    val fw = FileWriter(FILE_NAME)
    fw.write(writeString)
    fw.close()

    // 파일에서 읽기
    val content = StringBuilder()
    val fr = FileReader(FILE_NAME)
    var ch : Int
    while(fr.read().also { ch = it } != -1) {
        content.append(ch.toChar())
    }

    fr.close()

    println("read String: $content")


}
