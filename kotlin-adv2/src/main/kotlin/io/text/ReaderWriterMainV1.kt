package hello.io.text

import hello.io.text.TextConst.FILE_NAME
import java.io.FileInputStream
import java.io.FileOutputStream
import java.nio.charset.StandardCharsets.UTF_8

fun main() {
    val writeString = "ABC"
    // 문자 - byte UTF-8 인코딩
    val writeBytes = writeString.toByteArray(UTF_8)
    println("write String: $writeString")
    println("write Bytes: ${writeBytes.contentToString()}")

    // 파일에 쓰기
    val fos = FileOutputStream(FILE_NAME)
    fos.write(writeBytes)
    fos.close()

    // 파일에서 읽기
    val fis = FileInputStream(FILE_NAME)
    val readBytes = fis.readAllBytes()

    // byte - String UTF-8 디코딩
    val readString = String(readBytes, UTF_8)
    println("read Bytes: ${readBytes.contentToString()}")
    println("read String: $readString")
    fis.close()
}
