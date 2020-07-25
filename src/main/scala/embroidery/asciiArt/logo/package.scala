package embroidery
package asciiArt

package object logo {

  def printWithArt(urlImg: String, style: LogoStyle = LogoStyle.default): Unit =
    URL(urlImg).fold(println(s"<Error> Invalid extension in $urlImg")) { url =>
      val logoArt = LogoArt(url, style).toAsciiArt
      println(logoArt)
    }
  def printWithArt(urlImg: String, pixelsWithArt: List[PixelAsciiArt]): Unit =
    URL(urlImg).fold(println(s"<Error> Invalid extension in $urlImg")) { url =>
      val logoArt = LogoArt(url, LogoStyle(pixelsWithArt)).toAsciiArt
      println(logoArt)
    }

  def asciiArt(urlImg: String, style: LogoStyle = LogoStyle.default): String =
    URL(urlImg).fold(s"<Error> Invalid extension in $urlImg") { url =>
      LogoArt(url, style).toAsciiArt
    }
  def asciiArt(urlImg: String, pixelsWithArt: List[PixelAsciiArt]): String =
    URL(urlImg).fold(s"<Error> Invalid extension in $urlImg") { url =>
      LogoArt(url, LogoStyle(pixelsWithArt)).toAsciiArt
    }
}
