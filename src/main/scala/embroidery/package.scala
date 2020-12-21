package object embroidery {

  /**
    * Apply asciiArt to any string
    */
  implicit class TitleHelper(val text: String) extends AnyVal {
    def toAsciiArt: String =
      title.asciiArt(text)

    def toAsciiArt(art: Char): String =
      title.asciiArt(text, art = art)

    def toAsciiArt(art: Char, spaces: Int): String =
      title.asciiArt(text, art = art, spaces = spaces)

    def toAsciiArt(spaces: Int): String =
      title.asciiArt(text, spaces = spaces)
  }

  /**
    * Apply asciiArt to any image path.
    * @example
    * ImagePath("src/img/logo.png").toAsciiArt
    */
  type ImagePath     = logo.LogoPath
  type PixelAsciiArt = logo.PixelAsciiArt
  val ImagePath: logo.LogoPath.type          = logo.LogoPath
  val PixelAsciiArt: logo.PixelAsciiArt.type = logo.PixelAsciiArt

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
