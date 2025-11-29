package hello.chat.server

import hello.chat.server.command.ChangeCommand
import hello.chat.server.command.Command
import hello.chat.server.command.DefaultCommand
import hello.chat.server.command.ExitCommand
import hello.chat.server.command.JoinCommand
import hello.chat.server.command.MessageCommand
import hello.chat.server.command.UsersCommand

class CommandManagerV4(private val sessionManager: SessionManager) : CommandManager {

    companion object {
        private const val DELIMITER = "|"
        private val defaultCommand = DefaultCommand()
    }


    private val commands: Map<String, Command> = mapOf(
        "/join" to JoinCommand(sessionManager),
        "/message" to MessageCommand(sessionManager),
        "/change" to ChangeCommand(sessionManager),
        "/users" to UsersCommand(sessionManager),
        "/exit" to ExitCommand()
    )

    override fun execute(totalMessage: String, session: Session) {

        // /join|juna
        val args = totalMessage.split(DELIMITER)
        val key = args[0]

        // NullObject 패턴
        val command = commands[key] ?: defaultCommand
        command.execute(args, session)



    }
}
