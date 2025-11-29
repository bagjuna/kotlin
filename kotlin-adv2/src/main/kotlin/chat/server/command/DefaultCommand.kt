package hello.chat.server.command

import hello.chat.server.Session
import java.io.IOException


class DefaultCommand : Command {
//    override fun execute(args: Array<String?>?, session: Session) {
//        session.send("처리할 없는 명령어 입니다: " + args.contentToString())
//    }

    override fun execute(args: Array<String?>?, session: Session?) {
        session?.send("처리할 없는 명령어 입니다: " + args.contentToString())
    }
}

