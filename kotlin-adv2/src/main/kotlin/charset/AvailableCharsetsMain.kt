package hello.charset

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets

fun main() {
    // 이용 가능한 모든 Charset 출력
    val availableCharsets = Charset.availableCharsets()
    for ((name, charset) in availableCharsets) {
        println("Charset Name: $name, Charset: $charset")
    }

    println("=====")
    // 문자로 조회(대소문자 구분 X), MS949, ms949, win949 모두 동일하게 조회됨
    val charset1 = Charset.forName("MS949")
    println(charset1)

    // 별칭 조회
    val aliases = charset1.aliases()
    for (alias in aliases) {
        println("Alias: $alias")
    }

    // UTF-8 조회
    val charset2 = Charset.forName("utf-8")
    println("charset2: $charset2")

    // utf-8 표준 상수 이용
    val charset3 = StandardCharsets.UTF_8
    println("charset3: $charset3")

    // 시스템의 기본 Charset 조회
    val defaultCharset = Charset.defaultCharset()
    println("Default Charset: $defaultCharset")


}

