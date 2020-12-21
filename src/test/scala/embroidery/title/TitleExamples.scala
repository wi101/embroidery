package embroidery.title

object TitleExamples extends App {
  println(asciiArt("Hello World", '@', 2))
  println(asciiArt("Welcome", 1))
  println(asciiArt("WELCOME", '^', 1))
  println(asciiArt("Peace", '+', 0))
  println(asciiArt("Scala", 'S', 1))
  // invalid title
  println(asciiArt("a" * 70, 1))
}
