package embroidery
package asciiArt
package title

import java.awt.Font
import java.awt.image.BufferedImage

case class TitleArt(title: Title, art: Art) extends Embroidery {
  val defaultSize = 12

  override def drawImage(): BufferedImage = {
    val emptyImage = new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_BINARY)
    val graphics = emptyImage.getGraphics
    val font = new Font("Default", Font.BOLD, defaultSize)
    graphics.setFont(font)
    val metrics = graphics.getFontMetrics(font)
    val width = metrics.stringWidth(title.value)
    val position = metrics.getAscent - metrics.getDescent
    val image =
      new BufferedImage(width, defaultSize, BufferedImage.TYPE_BYTE_BINARY)
    val g = image.getGraphics
    g.drawString(title.value, 0, position)
    g.dispose()
    image
  }

  def getAsciiArt(pixel: Pixel): Char = if (pixel.value == 0) ' ' else art.value
}
