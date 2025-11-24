package hello.io.streams

import java.io.FileOutputStream
import java.io.PrintStream

fun main() {

    FileOutputStream("src/main/kotlin/temp/print.txt")
        .use { fos ->
            val printStream = PrintStream(fos)

            printStream.println("Hello, Java!")
            printStream.println(100)
            printStream.println(true)
            printStream.printf("hello %s", "world")

        }
}
