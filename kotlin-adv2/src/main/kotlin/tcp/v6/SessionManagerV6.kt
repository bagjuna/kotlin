package hello.tcp.v6

class
SessionManagerV6 {

    private val sessions: MutableList<SessionV6> = mutableListOf()
    @Synchronized
    fun add(session: SessionV6) {
        sessions.add(session)
    }

    @Synchronized
    fun remove(session: SessionV6) {
        sessions.remove(session)
    }

    @Synchronized
    fun closeAll() {
        for (session in sessions.toList()) {
            session.close()
        }
        sessions.clear()
    }


}
