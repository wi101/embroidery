package embroidery

object embroidery {
  def printWithSimpleArt(content: String, art: Char = '*'): Unit = {
    val text = Text(content, art)
    println(text.convertTextToSimpleASCIIArt)
  }
}
