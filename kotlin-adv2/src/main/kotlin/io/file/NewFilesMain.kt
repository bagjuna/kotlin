package hello.io.file

import java.nio.file.FileAlreadyExistsException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.attribute.BasicFileAttributes

fun main() {
    val file = Path.of("src/main/kotlin/temp/example.txt")
    val directory = Path.of("src/main/kotlin/temp/exampleDir")

    println("File exists: ${Files.exists(file)}")


    try {
        Files.createFile(file)
        println("File created")
    } catch (e: FileAlreadyExistsException) {
        println("$file File already exists")
    }
//    Files.createFile(file).also {
//        println("File created: ${Files.exists(file)}")
//    }

    try {
        Files.createDirectory(directory)
        println("Directory created")
    } catch (e: FileAlreadyExistsException) {
        println("$directory Directory already exists")
    }

//    Files.createDirectory(directory).also {
//        println("Directory created: ${Files.exists(directory)}")
//    }

//    Files.delete(file)
//    println("File deleted: ${!Files.exists(file)}")

    println("Is regular file: ${Files.isRegularFile(file)}")
    println("Is directory: ${Files.isDirectory(directory)}")
    println("File name: ${file.fileName} ")
    println("File size: ${Files.size(file)} bytes ")

    val newFile = Path.of("src/main/kotlin/temp/newExample.txt")
    Files.move(file, newFile)

    println("File renamed: ${Files.exists(newFile)}" )

    println("Last modified: ${Files.getLastModifiedTime(newFile)}")

    Files.readAttributes(newFile, BasicFileAttributes::class.java).also { attrs ->
        println("==== Attributes ====")
        println("Creation time: ${attrs.creationTime()}")
        println("Is directory: ${attrs.isDirectory}")
        println("Is regular file: ${attrs.isRegularFile}")
        println("is symbolic link: ${attrs.isSymbolicLink}")
    }

}
