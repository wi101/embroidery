package embroidery.asciiArt
package title

object TitleExamples extends App {
  println(title.asciiArt("Hello World", '@', 2))
  println(title.asciiArt("Welcome", 1))
  println(title.asciiArt("WELCOME", '^', 1))
  println(title.asciiArt("Peace", '+', 0))
  println(title.asciiArt("Scala", 'S', 1))
  // invalid title
  println(title.asciiArt("a" * 70).mkString, '1')
}
