package embroidery

package object asciiArt {

  // Common Data types
  final case class Art(value: Char) extends AnyVal

  final case class Pixel(value: Int) extends AnyVal

  final case class URL(value: String) extends AnyVal {
    def isValid: Boolean = {
      val regex = "[^\\s]+(\\.(?i)(jpg|jpeg|png|bmp))$"
      value.matches(regex)
    }
  }

  object URL {
    def apply(path: String): Option[URL] = {
      val url = new URL(path)
      if (url.isValid) Some(url) else None
    }
  }

  // Title
  final case class Title(value: String) extends AnyVal

  final case class TitleStyle(art: Art = Art('#'), spaces: Int = 0) {
    // currently the font size couldn't be modified
    val fontSize: Int = 12
  }
  object TitleStyle {
    val default: TitleStyle = new TitleStyle()
  }

  // Logo
  final case class PixelAsciiArt(pixel: Pixel, art: Art)

  final case class Size(width: Int, height: Int)
  final case class LogoStyle(pixelsWithArt: List[PixelAsciiArt] =
                               PixelAsciiArt.pixelsWithArt,
                             maxSize: Size = Size(50, 50)) {
    val darkestArt: Art =
      pixelsWithArt.lastOption.map(_.art).getOrElse(Art('#'))
  }

  object LogoStyle {
    val default: LogoStyle = new LogoStyle()
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

  final case class PixelMatrix(pixels: Array[Array[Pixel]])
}
