package hello.io.text

import hello.io.text.TextConst.FILE_NAME
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.FileReader
import java.io.FileWriter

const val BUFFER_SIZE = 8192

fun main() {



    val writeString = "abc\n가나다"
    println("== Write String ==")
    println(writeString)
    // 파일에 쓰기
    val fw = FileWriter(FILE_NAME)
    val bw = BufferedWriter(fw, BUFFER_SIZE)
    bw.write(writeString)
    bw.close()

    // 파일에서 읽기
    val content = StringBuilder()
    val fr = FileReader(FILE_NAME)
    val br = BufferedReader(fr, BUFFER_SIZE)

    var line : String?
    while(br.readLine().also {
        line = it
        } != null) {
        content.append(line).append("\n")
    }

    br.close()

    println("== Read String ==")
    println(content)

}
