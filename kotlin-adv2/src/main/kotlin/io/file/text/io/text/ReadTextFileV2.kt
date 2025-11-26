package hello.io.file.text.io.text

import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import kotlin.text.Charsets.UTF_8


fun main() {

    val PATH = "temp/hello2.txt"

    val writeString = "abc\n가나다"
    println("== Write String ==")
    println(writeString)

    val path = Path.of(PATH)

    // 파일에 쓰기
    Files.writeString(path, writeString, UTF_8)

    // 파일에서 읽기

    File(PATH).useLines { lines ->
        lines.forEach { println(it) }
    }

    val readString = Files.readString(path, Charsets.UTF_8)
    println("== Read String ==")

    // 인덱스와 내용을 한 번에 받음 (index는 0부터 시작하니까 +1)
//    val lines = Files.readAllLines(path, Charsets.UTF_8)
//    lines.forEachIndexed { index, line ->
//        println("${index + 1} : $line")
//    }
    for (i in 0 until readString.length) {
        println("${i+1} : ${readString[i]}")
    }
}

