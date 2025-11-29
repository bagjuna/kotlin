package hello.chat.server.command

import hello.chat.server.Session
import java.io.IOException


class ExitCommand : Command {
    override fun execute(args: List<String>, session: Session) {
        throw IOException("exit")
    }
}
