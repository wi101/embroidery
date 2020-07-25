package embroidery.asciiArt

import java.awt.Color
import java.awt.image.BufferedImage

abstract class Embroidery {
  protected def art: Art
  protected def drawImage(): BufferedImage

  private def toPixelMatrix: PixelMatrix = {
    val bufferedImg = drawImage()
    val width = bufferedImg.getWidth
    val height = bufferedImg.getHeight
    val matrix = Array.ofDim[Pixel](height, width)
    for {
      i <- 0 until height
      j <- 0 until width
    } {
      // if the background is transparent we must convert it to white color background
      val isTransparent = (bufferedImg.getRGB(j, i) & 0xff000000) == 0
      if (isTransparent)
        bufferedImg.setRGB(j, i, Color.white.getRGB & 0x00ffffff)

      val pixelColor = new Color(bufferedImg.getRGB(j, i))

      // calculate the brightness
      val pixel = (pixelColor.getRed + pixelColor.getBlue + pixelColor.getGreen) / 3
      matrix(i).update(j, Pixel(pixel.toInt))
    }
    PixelMatrix(matrix)
  }

  protected def getAsciiArt(pixel: Pixel): Char

  def toAsciiArt: String = {
    val matrix = toPixelMatrix
    matrix.pixels.foldLeft("") { (asciiArt, lines) =>
      asciiArt + lines.map(getAsciiArt).mkString + "\n"
    }
  }
}
