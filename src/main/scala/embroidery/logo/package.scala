package embroidery

package object logo {

  def asciiArt(path: String): String =
    LogoArt(path, LogoStyle.default).toAsciiArt

  def asciiArt(path: String, pixelsWithArt: List[PixelAsciiArt]): String =
    LogoArt(path, LogoStyle(pixelsWithArt)).toAsciiArt

  def asciiArt(path: String, width: Int, height: Int): String =
    LogoArt(path, LogoStyle(maxSize = Size(width, height))).toAsciiArt

  def asciiArt(path: String, pixelsWithArt: List[PixelAsciiArt], width: Int, height: Int): String =
    LogoArt(path, LogoStyle(pixelsWithArt, Size(width, height))).toAsciiArt
}
