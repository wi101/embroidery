package embroidery
package asciiArt
package logo

import java.awt.Image
import java.awt.image.BufferedImage
import java.io.{File, IOException}

import javax.imageio.ImageIO

final case class LogoArt(url: URL, logoStyle: LogoStyle) extends Embroidery {

  override def art: Art = logoStyle.darkestArt

  private def readLogo(): Option[BufferedImage] =
    try {
      val bufferedImage = ImageIO.read(new File(url.value))
      if (bufferedImage.getWidth == 0 || bufferedImage.getHeight == 0) None
      else Some(bufferedImage)
    } catch {
      case _: IOException =>
        println("Please check your URL..")
        None
    }

  override def drawImage(): BufferedImage = {
    val emptyImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB)
    readLogo().fold(emptyImage) { logo =>
      val (width, height) =
        calculatePreferredSize(logo.getWidth, logo.getHeight)
      val tmp = logo.getScaledInstance(width, height, Image.SCALE_SMOOTH)
      val scaledImg =
        new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB)
      val g = scaledImg.createGraphics()
      g.drawImage(tmp, 0, 0, width, height, null)
      g.dispose()
      scaledImg
    }
  }

  def getAsciiArt(pixel: Pixel): Char = {
    val darkestArt = PixelAsciiArt(Pixel(0), art)
    logoStyle.pixelsWithArt
      .find(i => pixel.value >= i.pixel.value)
      .getOrElse(darkestArt)
      .art
      .value
  }

  private def calculatePreferredSize(width: Int, height: Int): (Int, Int) = {
    val (maxW, maxH) = (50, 50)
    val x = if (width < maxW) width else maxW
    val y = if (height < maxH) height else maxH

    if (width > height) {
      val q: Float = width.toFloat / height.toFloat
      val newHeight = (x / q).toInt
      (x * 2, newHeight)
    } else if (height > width) {
      val q: Float = height.toFloat / width.toFloat
      val newWidth = (y / q).toInt
      (newWidth * 2, y)
    } else (x, y / 2) //if height == width
  }
}
