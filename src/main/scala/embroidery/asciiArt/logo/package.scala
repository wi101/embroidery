package embroidery
package asciiArt

package object logo {
  def printWithArt(urlImg: String) = {
    val url = URL(urlImg)
    if (url.validate) {
      val logoArt = LogoArt(URL(urlImg), Art('µ')).toAsciiArt
      println(logoArt)
    } else println(s"<Error> Invalid extension in $urlImg")
  }

  def asciiArt(urlImg: String): String = {
    val url = URL(urlImg)
    if (url.validate) {
      LogoArt(URL(urlImg), Art('µ')).toAsciiArt
    } else "<Error> Invalid extension in $urlImg"
  }
}
