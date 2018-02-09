package embroidery
package asciiArt

case class PixelAsciiArt(pixel: Pixel, art: Art)
object PixelAsciiArt {
  val maxBlankSpaceArt = PixelAsciiArt(Pixel(240), Art(' '))

  val sortedLightPixelsArt = List(PixelAsciiArt(Pixel(210), Art('.')), PixelAsciiArt(Pixel(190), Art('*')),
    PixelAsciiArt(Pixel(170), Art('~')), PixelAsciiArt(Pixel(120), Art('^')), PixelAsciiArt(Pixel(110), Art('&')),
    PixelAsciiArt(Pixel(80), Art('8')), PixelAsciiArt(Pixel(60), Art('#')))

  val pixelsWithArt: List[PixelAsciiArt] = maxBlankSpaceArt :: sortedLightPixelsArt
}
