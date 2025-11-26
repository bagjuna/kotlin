package hello.io.start

import java.io.FileInputStream
import java.io.FileOutputStream


fun main(){

    val fos = FileOutputStream("temp/hello.dat")
    fos.write(65)
    fos.write(66)
    fos.write(67)
    fos.close()

    val fis = FileInputStream("temp/hello.dat")
    println(fis.read())
    println(fis.read())
    println(fis.read())

    fis.close()
}
