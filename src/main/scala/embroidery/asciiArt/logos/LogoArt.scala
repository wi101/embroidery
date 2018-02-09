package embroidery.asciiArt
package logos

import java.awt.Image
import java.awt.image.BufferedImage
import java.io.{File, IOException}
import javax.imageio.ImageIO

case class LogoArt(url: URL, art: Art) extends Embroidery {

  private def readLogo(): Option[Logo] =
    try {
      val bufferedImage = ImageIO.read(new File(url.value))
      Some(Logo(bufferedImage))
    } catch {
      case e: IOException =>
        println("Please check your URL..")
        None
    }
  override def drawImage(): BufferedImage = {
    val emptyImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB)
    readLogo().fold(emptyImage){ logo =>
      val (width, height) = (70, 20) //FIXME calculate the prefered height & width
    val tmp = logo.image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
      val scaledImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
      val g = scaledImg.createGraphics()
      g.drawImage(tmp, 0, 0, width, height, null)
      g.dispose()
      scaledImg
    }
  }
}
