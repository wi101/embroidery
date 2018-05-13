package embroidery
package asciiArt

package object title {
  def printWithArt(str: String, art: Char = '#'): Unit = {
    val titleArt = TitleArt(Title(str), Art(art)).toAsciiArt
    println(titleArt)
  }
}
