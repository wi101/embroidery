package embroidery.asciiArt

package object titles {
  def printWithArt(str: String, art: Char = '*'): Unit = {
    val titleArt = TitleArt(Title(str), Art(art)).toAsciiArt()
    println(titleArt)
  }
}
