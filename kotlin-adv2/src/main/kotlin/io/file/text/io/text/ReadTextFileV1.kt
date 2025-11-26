package hello.io.file.text.io.text

import java.nio.file.Files
import java.nio.file.Path


fun main() {

    val PATH = "temp/hello2.txt"
    val writeString = "abc\n가나다"
    println("== Write String ==")
    println(writeString)

    val path = Path.of(PATH)

    // 파일에 쓰기
    Files.writeString(path, writeString, Charsets.UTF_8)

    // 파일에서 읽기
    val readString = Files.readString(path, Charsets.UTF_8)

    println("== Read String ==")
    println(readString)
}

