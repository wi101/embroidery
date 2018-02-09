package embroidery.asciiArt

package object logos {
  def printWithArt(urlImg: String) = {
    val logoArt = LogoArt(URL(urlImg), Art('@')).toAsciiArt()
    println(logoArt)
  }
}
