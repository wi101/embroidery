package embroidery
package title

object TitleExamples extends App {
  println("Hello World".toAsciiArt('@', 2))
  println("Welcome".toAsciiArt(1))
  println("WELCOME".toAsciiArt('^', 1))
  println("Peace".toAsciiArt('+', 0))
  println("Scala".toAsciiArt('S', 1))
  // invalid title
  println(("a" * 70).toAsciiArt)
}
