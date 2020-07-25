package embroidery.asciiArt

object TitleExamples extends App {
  title.printWithArt("Hello World", 2)
  title.printWithArt("SCALA", '*')
  title.printWithArt("Scala", 'S', 1)

  title.printWithArt("ZIO", 2)
}
