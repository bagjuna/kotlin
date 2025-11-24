package charset

import java.nio.charset.Charset
import java.nio.charset.StandardCharsets.ISO_8859_1
import java.nio.charset.StandardCharsets.US_ASCII
import java.nio.charset.StandardCharsets.UTF_16BE
import java.nio.charset.StandardCharsets.UTF_8


private val EUC_KR: Charset = Charset.forName("EUC-KR")
private val MS_949: Charset = Charset.forName("MS949")

fun main() {
    println("== ASCII 영문 처리 ==")
    encoding("A", US_ASCII)
    encoding("A", ISO_8859_1)
    encoding("A", EUC_KR)
    encoding("A", UTF_8)
    encoding("A", UTF_16BE)


    println("== 한글 지원 ==")
    encoding("가", EUC_KR)
    encoding("가", MS_949)
    encoding("가", UTF_8)
    encoding("가", UTF_16BE)
}

private fun encoding(text: String, charset: Charset) {
    val bytes = text.toByteArray(charset)
//    System.out.printf("%s -> [%s] 인코딩 %s %sbyte\n", text, charset, bytes.contentToString(), bytes.size)
    println("$text -> [${charset.name()}] 인코딩 ${bytes.contentToString()} ${bytes.size}byte")

}
