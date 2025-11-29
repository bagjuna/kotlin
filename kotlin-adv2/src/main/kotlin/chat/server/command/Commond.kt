package hello.chat.server.command

import hello.chat.server.Session

interface Command {
    fun execute(args: Array<String?>?, session: Session?)

}
