package embroidery.asciiArt
package title

import java.awt.Font
import java.awt.image.BufferedImage

final case class TitleArt(title: Title, titleStyle: TitleStyle)
    extends Embroidery {

  override def drawImage(): BufferedImage = {
    import titleStyle._

    val emptyImage = new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_BINARY)
    val graphics = emptyImage.getGraphics
    val font = new Font(Font.SANS_SERIF, Font.PLAIN, fontSize)
    graphics.setFont(font)
    val spacesStr = (1 to spaces).map(_ => ' ').mkString
    val text = title.value.flatMap(_ + spacesStr)
    val metrics = graphics.getFontMetrics(font)
    val width = metrics.stringWidth(text)
    val height = metrics.getHeight
    val image =
      new BufferedImage(
        width + metrics.getAscent,
        height + metrics.getDescent,
        BufferedImage.TYPE_BYTE_BINARY
      )
    val g = image.getGraphics
    g.drawString(text, metrics.getLeading, height)
    g.dispose()
    image
  }

  def getAsciiArt(pixel: Pixel): Char =
    if (pixel.value == 0) ' ' else titleStyle.art.value
}
