package hello.chat.client

import hello.util.MyLogger.log
import java.io.DataOutputStream
import java.io.IOException
import java.util.*

class WriteHandler(
    private val output: DataOutputStream,
    private val client: Client
) : Runnable {
    private var closed: Boolean = false

    val DELIMITER: String = "|"

    override fun run() {
        val sc = Scanner(System.`in`)
        try {
            val name = inputUserName(sc)
            output.writeUTF("/join$DELIMITER$name")

            while (true) {
                val toSend = sc.nextLine()

                if (toSend.isEmpty()) {
                    continue
                }
                if (toSend == "exit") {
                    output.writeUTF(toSend)
                    break
                }

                if (toSend.startsWith("/")) {
                    output.writeUTF(toSend)
                } else {
                    output.writeUTF("/message$DELIMITER$toSend")
                }
            }
        }
        // IOException 이거나 NoSuchElementException
        catch (e: IOException) {
            log(e)
        } catch (e: NoSuchElementException) {
            log(e)
        } finally {
            client.close()
        }
    }

    @Synchronized
    fun close() {
        if (closed) {
            return
        }

        try {
            System.`in`.close()
        } catch (e: IOException) {
            log(e)
        }

        closed = true
        log("writeHandler 종료")
    }

    fun inputUserName(sc: Scanner): String {
        println("이름을 입력하세요.")
        var username: String
        do{
            username = sc.nextLine()
            if(username.isEmpty()){
                println("이름은 한 글자 이상이어야 합니다. 다시 입력하세요.")
            }
        } while (username.isEmpty())

        return username
    }
}
