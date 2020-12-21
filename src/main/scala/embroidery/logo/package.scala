package embroidery

package object logo {

  def asciiArt(urlImg: String): String =
    LogoArt(urlImg, LogoStyle.default).toAsciiArt

  def asciiArt(urlImg: String, pixelsWithArt: List[PixelAsciiArt]): String =
    LogoArt(urlImg, LogoStyle(pixelsWithArt)).toAsciiArt

  def asciiArt(urlImg: String, width: Int, height: Int): String =
    LogoArt(urlImg, LogoStyle(maxSize = Size(width, height))).toAsciiArt

  def asciiArt(urlImg: String, pixelsWithArt: List[PixelAsciiArt], width: Int, height: Int): String =
    LogoArt(urlImg, LogoStyle(pixelsWithArt, Size(width, height))).toAsciiArt
}
