package embroidery
package title

import java.awt.Font
import java.awt.image.BufferedImage

final case class TitleArt private (title: Title) extends Embroidery {

  override def drawImage(): BufferedImage = {
    import title.style._

    val emptyImage = new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_BINARY)
    val graphics   = emptyImage.getGraphics
    val font       = new Font(Font.SANS_SERIF, Font.PLAIN, fontSize)
    graphics.setFont(font)
    val metrics = graphics.getFontMetrics(font)
    val width   = metrics.stringWidth(title.text)
    val height  = metrics.getHeight
    val image =
      new BufferedImage(
        width + metrics.getAscent,
        height + metrics.getDescent,
        BufferedImage.TYPE_BYTE_BINARY
      )
    val g = image.getGraphics
    g.drawString(title.text, metrics.getLeading, height)
    g.dispose()
    image
  }

  def getAsciiArt(pixel: Pixel): Char =
    if (pixel.value == 0) ' ' else title.style.art.value
}

object TitleArt {
  def apply(value: String, style: TitleStyle = TitleStyle.default): Embroidery =
    Title(value, style).fold[Embroidery](Embroidery.Empty, TitleArt(_))
}
