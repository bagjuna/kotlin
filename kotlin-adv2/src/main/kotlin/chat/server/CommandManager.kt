package hello.chat.server

import java.io.IOException

interface CommandManager {
    fun execute(totalMessage: String, session: Session)
}
