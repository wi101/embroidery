package embroidery
package asciiArt

package object logo {
  def printWithArt(urlImg: String) = {
    val url = URL(urlImg)
    if (url.validate) {
      val logoArt = LogoArt(URL(urlImg), Art('@')).toAsciiArt
      println(logoArt)
    } else println(s"<Error> Invalid extension in $urlImg")
  }
}
