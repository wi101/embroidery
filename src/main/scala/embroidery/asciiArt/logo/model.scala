package embroidery.asciiArt
package logo

final case class URL private (value: String) extends AnyVal {
  def isValid: Boolean = {
    val regex = "[^\\s]+(\\.(?i)(jpg|jpeg|png|bmp))$"
    value.matches(regex)
  }
}

object URL {
  def apply(path: String): Either[String, URL] = {
    val url = new URL(path)
    if (url.isValid) Right(url)
    else Left(s"Invalid path: $path, Embroidery supports only: jpg, jpeg, png, bmp formats.")
  }
}

// Logo
final case class PixelAsciiArt(pixel: Pixel, art: Art)

final case class Size(width: Int, height: Int)
final case class LogoStyle private (
    pixelsWithArt: List[PixelAsciiArt] = PixelAsciiArt.pixelsWithArt,
    maxSize: Size = Size(100, 100)
) {
  def isValid: Boolean = maxSize.width > 10 || maxSize.height > 10
  val darkestArt: Art =
    pixelsWithArt.lastOption.map(_.art).getOrElse(Art('#'))
}

object LogoStyle {
  val default: Either[String, LogoStyle] = Right(new LogoStyle(PixelAsciiArt.pixelsWithArt))

  def apply(
      pixelsWithArt: List[PixelAsciiArt] = PixelAsciiArt.pixelsWithArt,
      maxSize: Size = Size(100, 100)
  ): Either[String, LogoStyle] = {
    if (maxSize.width >= 20 || maxSize.height >= 20) Right(new LogoStyle(pixelsWithArt, maxSize))
    else Left("maxSize should be at least [20, 20]")
  }
}

object PixelAsciiArt {
  val pixelsWithArt: List[PixelAsciiArt] = List(
    // Brightest:255 ----> Darkest:0
    PixelAsciiArt(Pixel(255), Art(' ')),
    PixelAsciiArt(Pixel(230), Art('.')),
    PixelAsciiArt(Pixel(220), Art(',')),
    PixelAsciiArt(Pixel(210), Art('°')),
    PixelAsciiArt(Pixel(200), Art('²')),
    PixelAsciiArt(Pixel(190), Art('*')),
    PixelAsciiArt(Pixel(180), Art('^')),
    PixelAsciiArt(Pixel(170), Art('~')),
    PixelAsciiArt(Pixel(150), Art('/')),
    PixelAsciiArt(Pixel(140), Art('|')),
    PixelAsciiArt(Pixel(130), Art('s')),
    PixelAsciiArt(Pixel(120), Art('q')),
    PixelAsciiArt(Pixel(90), Art('#')),
    PixelAsciiArt(Pixel(70), Art('@')),
    PixelAsciiArt(Pixel(0), Art('µ'))
  )
}
