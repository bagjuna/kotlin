package hello.tcp.autocloseable


object ResourceCloseMainV2 {
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

    @Throws(CallException::class, CloseException::class)
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
            resource2?.closeEx() // closeException 발생
            resource1?.closeEx() // 호출되지 않음
        }
    }
}
