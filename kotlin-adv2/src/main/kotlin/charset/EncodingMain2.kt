package hello.charset

import java.nio.charset.Charset
import kotlin.text.Charsets.ISO_8859_1
import kotlin.text.Charsets.US_ASCII
import kotlin.text.Charsets.UTF_16BE
import kotlin.text.Charsets.UTF_8


private val EUC_KR: Charset = Charset.forName("EUC-KR")
private val MS_949: Charset = Charset.forName("MS949")


fun main() {
    println("==영문 ASCII 영문 처리 ==")
    test("A", US_ASCII, US_ASCII)
    test("A", US_ASCII, ISO_8859_1) // ASCII 확장(Latin-1)
    test("A", US_ASCII, EUC_KR)     // ASCII 포함
    test("A", US_ASCII, MS_949)     // ASCII 포함
    test("A",US_ASCII, UTF_8)       // ASCII 포함
    test("A",US_ASCII, UTF_16BE)    // UTF-16BE 디코딩 실패

    println("==한글 처리 ==")
    test("가", US_ASCII, US_ASCII)
    test("가", ISO_8859_1, ISO_8859_1)
    test("가", EUC_KR, EUC_KR)
    test("가", MS_949, MS_949)
    test("가", UTF_8, UTF_8)
    test("가", UTF_16BE, UTF_16BE)


    println("==한글 인코딩 - 복잡한 문자 ==")
    test("봵", EUC_KR, EUC_KR)
    test("봵", MS_949, MS_949)
    test("봵", UTF_8, UTF_8)
    test("봵", UTF_16BE, UTF_16BE)

    println("== 한글 인코딩 - 디코딩이 다른 경우 ==")
    test("가", EUC_KR, MS_949)
    test("봵", MS_949, EUC_KR) // 인코딩 가능, 디코딩 X
    test("봵", EUC_KR, MS_949) // X
    test("가", UTF_8, EUC_KR)  // X

    println("== 영문 인코딩 - 디코딩이 다른 경우 ==")
    test("A", EUC_KR, UTF_8)
    test("A", MS_949, UTF_8)
    test("A", UTF_8, EUC_KR)
    test("A", UTF_8, UTF_16BE) // X


}

fun test(text: String, encodingCharset: Charset, decodingCharset: Charset) {
    val encoded = text.toByteArray(encodingCharset)
    val decoded = String(encoded, decodingCharset)
    println("$text -> [${encodingCharset}] 인코딩 -> " +
            "${encoded.contentToString()} " +
            "${encoded.size}byte -> " +
            "[${decodingCharset.name()} 디코딩] -> $decoded")
}
