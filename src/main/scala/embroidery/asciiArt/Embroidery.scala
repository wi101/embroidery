package embroidery.asciiArt

import java.awt.image.BufferedImage

trait Embroidery {
  val art: Art
  def drawImage(): BufferedImage

  def toPixelMatrix(): PixelMatrix = {
    val bufferedImage = drawImage()
    imageToPixelMatrix(bufferedImage)
  }

  def toAsciiArt(): String = {
    val matrix = toPixelMatrix()
    convertToAsciiArt(art, matrix)
  }
}
