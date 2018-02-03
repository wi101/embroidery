package embroidery

import java.awt.{Font, Graphics2D}
import java.awt.image.BufferedImage

case class Text(content: String, art: Char) {
  private val defaultSize = 12

  def toImage: Image = {
    val emptyImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB)
    val graphics2D = emptyImage.createGraphics()
    val font = new Font("Default", Font.BOLD, defaultSize)
    val metrics = graphics2D.getFontMetrics(font)
    val width = metrics.stringWidth(content)
    val height = metrics.getHeight
    val position = metrics.getAscent - metrics.getDescent
    val image = Image(new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB), width, height)
    image.graphics2D.drawString(content, 0, position)
    image
  }
}

case class Image(bufferedImg: BufferedImage, width: Int, height: Int) {
  val graphics2D: Graphics2D = bufferedImg.createGraphics()

  def toMatrixOfPixels(): Array[Array[Pixel]] = {
    val matrix = Array.ofDim[Pixel](height, width)
    for {
      i <- 0 until height
      j <- 0 until width
    } (matrix(i).update(j, Pixel(value = bufferedImg.getRGB(j, i))))
    matrix
  }
}

case class Pixel(value: Int)
