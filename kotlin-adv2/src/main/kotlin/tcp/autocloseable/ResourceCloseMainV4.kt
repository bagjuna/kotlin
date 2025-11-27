package hello.tcp.autocloseable

object ResourceCloseMainV4 {
    @JvmStatic
    fun main(args: Array<String>) {
        try {
            logic()
        } catch (e: CallException) {
            println("CallException 예외 처리")
            val suppressed = e.suppressed
            for (s in suppressed) {
                println("suppressed: $s")
            }
        } catch (e: CloseException) {
            println("CloseException 예외 처리")
            throw RuntimeException(e)
        }
    }

    private fun logic() {
        try {
            ResourceV2("resource1").use { resource1 ->
                ResourceV2("resource2").use { resource2 ->
                    resource1.call()
                    resource2.callEx() // CallException
                }
            }
        } catch (e: CallException) {
            println("ex: $e")
            throw e
        }

    }
}
