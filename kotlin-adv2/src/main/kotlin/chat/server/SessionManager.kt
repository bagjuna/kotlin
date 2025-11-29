package hello.chat.server

import hello.util.MyLogger.log
import java.io.IOException


class SessionManager {

    private val sessions: MutableList<Session> = mutableListOf()

    @Synchronized
    fun add(session: Session) {
        sessions.add(session)
    }

    @Synchronized
    fun remove(session: Session) {
        sessions.remove(session)
    }

    @Synchronized
    fun sendAll(message: String?) {
        for (session in sessions.toList()) {
            try {
                session.send(message)
            }catch (e: IOException) {
                log(e)
            }
        }

    }
    @Synchronized
    fun closeAll() {
        for (session in sessions.toList()) {
            session.close()
        }
        sessions.clear()
    }

    @Synchronized
    fun getAllUsernames(): List<String> {
        return sessions.map { it.username }

    }


}
