package embroidery.asciiArt

object TitleExamples extends App {
  title.printWithArt("Hello World", spaced = Some(1))
  title.printWithArt("SCALA", '*', Some(2))
  title.printWithArt("scala", 'G', Some(1))
  title.printWithArt("ZIO", 'Z', Some(3))
}
