package embroidery
package asciiArt

package object title {
  def printWithArt(str: String,
                   art: Char = '#',
                   spaced: Option[Int] = None): Unit = {
    val titleArt = TitleArt(Title(str), Art(art), spaced).toAsciiArt
    println(titleArt)
  }
  def asciiArt(str: String,
               art: Char = '#',
               spaced: Option[Int] = None): String =
    TitleArt(Title(str), Art(art), spaced).toAsciiArt
}
