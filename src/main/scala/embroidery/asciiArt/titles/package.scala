package embroidery.asciiArt

package object titles {
  def titleWithArt(title: Title, art: Art): String = TitleArt(title, art).toAsciiArt()
  def printWithArt(str: String, art: Char = '*'): Unit = println(titleWithArt(Title(str), Art(art)))
}
