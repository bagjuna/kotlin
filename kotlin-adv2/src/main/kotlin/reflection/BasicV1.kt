package hello.reflection

import hello.reflection.data.BasicData

fun main() {

    // 클래스 메타데이터 조회 방법 3가지

    // 1. 클래스에서 찾기
    val basicDataClass = BasicData::class
    println("basicDataClass: $basicDataClass")

    // 2. 인스턴스에서 찾기
    val basicData = BasicData()
    val basicDataInstanceClass = basicData::class
    println("basicDataInstanceClass: $basicDataInstanceClass")

    // 3. 문자로 찾기
    val className = "hello.reflection.data.BasicData"
    val basicDataClassByName = Class.forName(className)
    println("basicDataClassByName: $basicDataClassByName")


}
