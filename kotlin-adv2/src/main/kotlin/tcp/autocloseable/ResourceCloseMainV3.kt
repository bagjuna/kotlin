package hello.tcp.autocloseable

object ResourceCloseMainV3 {
    @JvmStatic
    fun main(args: Array<String>) {
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

    private fun logic() {
        var resource1: ResourceV1? = null
        var resource2: ResourceV1? = null
        try {
            resource1 = ResourceV1("resource1")
            resource2 = ResourceV1("resource2")

            resource1.call()
            resource2.callEx() // CallException
        } catch (e: CallException) {
            println("ex: $e")
            throw e
        } finally {
            try {
                resource2?.closeEx()
            } catch (e: CloseException) {
                // close()에서 발생한 예외는 버린다. 필요하면 로그를 남긴다.
                println("closeEx: $e")
            }
            try {
                resource1?.closeEx() // 호출되지 않음
            } catch (e: CloseException) {
                println("closeEx: $e")
            }
        }
    }
}
