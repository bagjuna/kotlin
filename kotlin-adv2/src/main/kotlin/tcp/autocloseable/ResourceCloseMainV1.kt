package hello.tcp.autocloseable

fun main() {
    try {
        logic()
    } catch (e: CallException) {
        println("CallException 예외 처리")
        throw RuntimeException(e)
    } catch (e: CloseException) {
        println("CloseException 예외 처리")
        throw RuntimeException(e)
    }

}

fun logic() {
    val resourceV1 = ResourceV1("resourceV1")
    val resourceV2 = ResourceV1("resourceV2")


    resourceV1.call()
    resourceV2.callEx() // CallException 발생

    println("== 자원 정리 ==") // 호출 되지 않음
    resourceV2.closeEx()
    resourceV1.closeEx()

}
