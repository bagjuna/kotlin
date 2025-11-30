package hello.was.v3

import java.net.URLDecoder
import java.net.URLEncoder
import kotlin.text.Charsets.UTF_8

fun main() {
    val encode = URLEncoder.encode("가", UTF_8)
    println("encode: $encode")

    val decode = URLDecoder.decode(encode, UTF_8)
    println("decode: $decode")

}
