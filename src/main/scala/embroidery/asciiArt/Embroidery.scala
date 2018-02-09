package embroidery.asciiArt

import java.awt.Color
import java.awt.image.BufferedImage

trait Embroidery {
  protected val art: Art
  protected def drawImage(): BufferedImage

  private def toPixelMatrix(): PixelMatrix = {
    val bufferedImg = drawImage()
    val width = bufferedImg.getWidth
    val height = bufferedImg.getHeight
    val matrix = Array.ofDim[Pixel](height, width)
    for {
      i <- 0 until height
      j <- 0 until width
    } {
      val pixcol = new Color(bufferedImg.getRGB(j, i))
      val pixel = (((pixcol.getRed() * 0.30) + (pixcol.getBlue() * 0.59) + (pixcol.getGreen() * 0.11)))
      matrix(i).update(j, Pixel(pixel.toInt))
    }
    PixelMatrix(matrix)
  }

  protected def getAsciiArt(pixel: Pixel): Char = {
    val darkestArt = PixelAsciiArt(Pixel(0), art)
    PixelAsciiArt.pixelsWithArt.find(i => pixel.value >= i.pixel.value).getOrElse(darkestArt).art.value
  }


  def toAsciiArt(): String = {
    val matrix = toPixelMatrix()
    matrix.pixels.foldLeft("") {
      (asciiArt, lines) =>
        asciiArt + lines.map { pixel => getAsciiArt(pixel) }.mkString + "\n"
    }
  }
}
