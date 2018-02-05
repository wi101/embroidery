package embroidery

import java.awt.{Font, Graphics2D}
import java.awt.image.BufferedImage

sealed trait ASCIIArt {
  val art: Char
}
case class Text(content: String, art: Char) extends ASCIIArt {
  private val defaultSize = 12

  def toImage: Image = {
    val emptyImage = new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_BINARY)
    val graphics = emptyImage.getGraphics()
    val font = new Font("Default", Font.BOLD, defaultSize)
    graphics.setFont(font)
    val metrics = graphics.getFontMetrics(font)
    val width = metrics.stringWidth(content)
    val height = defaultSize
    val position = metrics.getAscent - metrics.getDescent
    val image = Image(new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY), art)
    image.graphics2D.drawString(content, 0, position)
    image.graphics2D.dispose()
    image
  }
}

case class Image(bufferedImg: BufferedImage, art: Char) extends ASCIIArt {
  val graphics2D: Graphics2D = bufferedImg.createGraphics()

  def toMatrixOfPixels(): Array[Array[Pixel]] = {
    val width = bufferedImg.getWidth
    val height = bufferedImg.getHeight
    val matrix = Array.ofDim[Pixel](height, width)
    for {
      i <- 0 until height
      j <- 0 until width
    } (matrix(i).update(j, Pixel(value = bufferedImg.getRGB(j, i))))
    matrix
  }
}
