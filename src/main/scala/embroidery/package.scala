package object embroidery {
  import logo._

  /**
    * Apply asciiArt to any string
    */

  implicit class TitleHelper(val str: String) extends AnyVal {
    def toAsciiArt: String =
      title.asciiArt(str)

    def toAsciiArt(art: Char): String =
      title.asciiArt(str, art = art)

    def toAsciiArt(art: Char, spaces: Int): String =
      title.asciiArt(str, art = art, spaces = spaces)

    def toAsciiArt(spaces: Int): String =
      title.asciiArt(str, spaces = spaces)
  }

  /**
    * Apply asciiArt to any string
    */
  def asciiArt(urlImg: String): String =
    LogoArt(urlImg, LogoStyle.default).toAsciiArt

  def asciiArt(urlImg: String, pixelsWithArt: List[PixelAsciiArt]): String =
    LogoArt(urlImg, LogoStyle(pixelsWithArt)).toAsciiArt

  def asciiArt(urlImg: String, width: Int, height: Int): String =
    LogoArt(urlImg, LogoStyle(maxSize = Size(width, height))).toAsciiArt

  def asciiArt(urlImg: String, pixelsWithArt: List[PixelAsciiArt], width: Int, height: Int): String =
    LogoArt(urlImg, LogoStyle(pixelsWithArt, Size(width, height))).toAsciiArt

  /**
    * Apply asciiArt to the image for a given path.
    * @example
    * ImagePath("src/img/logo.png").toAsciiArt
    */
  val ImagePath: logo.ImagePath.type = logo.ImagePath
  implicit class LogoHelper(val path: ImagePath) extends AnyVal {
    def toAsciiArt: String =
      logo.asciiArt(path.value)

    def toAsciiArt(pixelsWithArt: List[PixelAsciiArt]): String =
      logo.asciiArt(path.value, pixelsWithArt)

    def toAsciiArt(width: Int, height: Int): String =
      logo.asciiArt(path.value, width, height)

    def toAsciiArt(pixelsWithArt: List[PixelAsciiArt], width: Int, height: Int): String =
      logo.asciiArt(path.value, pixelsWithArt, width, height)
  }

}
