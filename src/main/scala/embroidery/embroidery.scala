package embroidery

object embroidery extends App {

  def printWithArt(content: String, art: Char = '*'): Unit = {
    val text = Text(content, art)
    println(text.toImageText)
  }
  printWithArt("Hello world")
}
