package hello.chat.server.command

import hello.chat.server.Session


class DefaultCommand : Command {

    override fun execute(args: List<String>, session: Session) {
        session?.send("처리할 없는 명령어 입니다: $args")
    }
}

