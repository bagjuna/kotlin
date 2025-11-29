package hello.chat.server

import java.io.IOException

class CommandManagerV1(private val sessionManager: SessionManager) : CommandManager {

    override fun execute(totalMessage: String?, session: Session?) {
        if (totalMessage?.startsWith("/exit") == true) {
            throw IOException("exit")
        }

        sessionManager.sendAll(totalMessage)
    }
}
