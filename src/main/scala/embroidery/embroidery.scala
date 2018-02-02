package embroidery

object embroidery {

  def printWithArt(content: String, size: Int = 12, art: Char = '*'): Unit = {
    val text = Text(content, size, art)
    println(text.toImageText)
  }
}
