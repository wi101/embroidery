package embroidery
package logo

final case class ImagePath(value: String) {
  override def toString: String = value
}

// Logo
final case class PixelAsciiArt(pixel: Pixel, art: Art)

final case class Size(width: Int, height: Int) {
  override def toString: String = s"[width:$width, height:$height]"
}

final case class LogoStyle private (
    pixelsWithArt: List[PixelAsciiArt],
    maxSize: Size
) {
  def isValid: Boolean = maxSize.width > 10 || maxSize.height > 10
  val darkestArt: Art =
    pixelsWithArt.lastOption.map(_.art).getOrElse(Art('#'))
}

object LogoStyle {
  val MinSize                            = Size(20, 20)
  val defaultSize                        = Size(20, 20)
  val default: Either[String, LogoStyle] = Right(new LogoStyle(PixelAsciiArt.pixelsWithArt, defaultSize))
  def apply(
      pixelsWithArt: List[PixelAsciiArt] = PixelAsciiArt.pixelsWithArt,
      maxSize: Size = defaultSize
  ): Either[String, LogoStyle] = {
    if (maxSize.width >= MinSize.width || maxSize.height >= MinSize.height) Right(new LogoStyle(pixelsWithArt, maxSize))
    else Left(s"$maxSize is invalid, it should be at least $MinSize")
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
