package hello.chat.server.command

import hello.chat.server.Session

interface Command {
    fun execute(args: List<String>, session: Session)

}
