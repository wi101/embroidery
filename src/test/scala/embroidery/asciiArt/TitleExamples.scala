package embroidery.asciiArt

object TitleExamples extends App {
  title.printWithArt("Hello World", 2)
  title.printWithArt("Welcome", 1)
  title.printWithArt("WELCOME", 1)
  title.printWithArt("Peace", '+', 0)
  title.printWithArt("Scala", 'S', 1)

  title.printWithArt("ZIO", 1)
}
