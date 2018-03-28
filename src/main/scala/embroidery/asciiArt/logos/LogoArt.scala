package embroidery.asciiArt
package logos

import java.awt.{Color, Image}
import java.awt.image.BufferedImage
import java.io.{File, IOException}

import javax.imageio.ImageIO

import embroidery.Embroidery

case class LogoArt(url: URL, art: Art) extends Embroidery {

  private def readLogo(): Option[Logo] =
    try {
      val bufferedImage = ImageIO.read(new File(url.value))
      Some(Logo(bufferedImage))
    } catch {
      case _: IOException =>
        println("Please check your URL..")
        None
    }
  override def drawImage(): BufferedImage = {
    val emptyImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB)
    readLogo().fold(emptyImage){ logo =>
      val (width, height) = calculatePreferredSize(logo.image.getWidth, logo.image.getHeight)
      val tmp = logo.image.getScaledInstance(width, height, Image.SCALE_SMOOTH)
      val scaledImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB)
      val g = scaledImg.createGraphics()
      g.drawImage(tmp, 0, 0, width, height, null)
      g.dispose()
      scaledImg
    }
  }

  def getAsciiArt(pixel: Pixel): Char = {
    val darkestArt = PixelAsciiArt(Pixel(0), art)
    PixelAsciiArt.pixelsWithArt.find(i => pixel.value >= i.pixel.value).getOrElse(darkestArt).art.value
  }

  def calculatePreferredSize(width: Int, height: Int): (Int, Int) = {
    assert(width > 0 && height > 0)

    val (maxW, maxH) = (50, 50)
    val x = if (width < maxW) width else maxW
    val y = if (height < maxH) height else maxH

    if (width > height) {
      val q: Float = width.toFloat /height.toFloat
      val newHeight = (x / q).toInt
      (x * 2, newHeight)
    }
    else if (height > width) {
      val q: Float = height.toFloat / width.toFloat
      val newWidth = (y / q).toInt
      (newWidth * 2, y)
    } else (x, y / 2) //if height == width
  }
}
