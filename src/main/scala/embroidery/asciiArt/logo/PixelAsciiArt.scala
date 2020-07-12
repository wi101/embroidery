package embroidery
package asciiArt.logo

final case class PixelAsciiArt(pixel: Pixel, art: Art)

object PixelAsciiArt {
  val pixelsWithArt: List[PixelAsciiArt] = List(
    PixelAsciiArt(Pixel(240), Art(' ')),
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
    PixelAsciiArt(Pixel(70), Art('@'))
  )
}
