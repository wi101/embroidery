package embroidery
package asciiArt
package title

import java.awt.Font
import java.awt.image.BufferedImage

final case class TitleArt(title: Title, art: Art, spaced: Option[Int])
    extends Embroidery {
  val defaultSize = 12

  override def drawImage(): BufferedImage = {
    val emptyImage = new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_BINARY)
    val graphics = emptyImage.getGraphics
    val font = new Font("Default", Font.BOLD, defaultSize)
    graphics.setFont(font)
    val metrics = graphics.getFontMetrics(font)
    val width =
      metrics.stringWidth(title.value * spaced.map(_ + 1).getOrElse(1))
    val position = metrics.getAscent - metrics.getDescent
    val image =
      new BufferedImage(width, defaultSize, BufferedImage.TYPE_BYTE_BINARY)
    val g = image.getGraphics
    val spaces = spaced.map(s => (1 to s).map(_ => ' ').mkString)
    val t = title.value.flatMap(c => spaces.fold(c.toString)(c + _))
    g.drawString(t, 0, position)
    g.dispose()
    image
  }

  def getAsciiArt(pixel: Pixel): Char = if (pixel.value == 0) ' ' else art.value
}
