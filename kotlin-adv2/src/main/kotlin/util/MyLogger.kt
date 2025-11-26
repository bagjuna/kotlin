package hello.util

import java.time.LocalTime
import java.time.format.DateTimeFormatter


object MyLogger {
    private val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS")

    fun log(obj: Any?) {
        val time = LocalTime.now().format(formatter)
        System.out.printf("%s [%9s] %s\n", time, Thread.currentThread().name, obj)
    }
}
