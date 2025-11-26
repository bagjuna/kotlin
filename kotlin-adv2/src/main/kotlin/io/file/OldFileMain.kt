package hello.io.file

import java.io.File

fun main() {

    val file = File("temp/example.txt")
    val directory = File("temp/exampleDir")

    println("File Exists: ${file.exists()}")

    val created = file.createNewFile()
    println("File Created: $created")

    val dirCreated = directory.mkdir()
    println("Directory Created: $dirCreated")

//    val deleted = file.delete()
//    println("File Deleted: $deleted")

//    val dirDeleted = directory.delete()
//    println("Directory Deleted: $dirDeleted")

    println("Is File: ${file.isFile} ")
    println("Is Directory: ${directory.isDirectory} ")
    println("File Name: ${file.name} ")
    println("File size: ${file.length()} bytes ")

    val newFile = File("temp/newExample.txt")
    val renamed = file.renameTo(newFile)
    println("File Renamed: $renamed")

    val lastModified = file.lastModified()
    println("Last Modified: $lastModified")
}
