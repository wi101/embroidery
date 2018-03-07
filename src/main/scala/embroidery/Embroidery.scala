package embroidery

import java.awt.Color
import java.awt.image.BufferedImage

import embroidery.asciiArt.{Art, Pixel, PixelAsciiArt, PixelMatrix}

trait Embroidery {
  protected val art: Art
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
      val pixelColor = new Color(bufferedImg.getRGB(j, i))
      val pixel = (pixelColor.getRed * 0.30) + (pixelColor.getBlue * 0.59) + (pixelColor.getGreen * 0.11)
      matrix(i).update(j, Pixel(pixel.toInt))
    }
    PixelMatrix(matrix)
  }

  protected def getAsciiArt(pixel: Pixel): Char = {
    val darkestArt = PixelAsciiArt(Pixel(0), art)
    PixelAsciiArt.pixelsWithArt.find(i => pixel.value >= i.pixel.value).getOrElse(darkestArt).art.value
  }


  def toAsciiArt: String = {
    val matrix = toPixelMatrix
    matrix.pixels.foldLeft("") {
      (asciiArt, lines) =>
        asciiArt + lines.map { pixel => getAsciiArt(pixel) }.mkString + "\n"
    }
  }
}
