package embroidery.asciiArt

// Common Data types
final case class Art(value: Char) extends AnyVal

final case class Pixel(value: Int) extends AnyVal

final case class PixelMatrix(pixels: Array[Array[Pixel]])
