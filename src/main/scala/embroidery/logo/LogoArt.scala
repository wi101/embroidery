package embroidery.logo

import java.awt.Image
import java.awt.image.BufferedImage
import java.io.{ File, IOException }
import javax.imageio.ImageIO

import embroidery.{ Embroidery, Pixel }

final case class LogoArt private (logo: BufferedImage, url: LogoPath, logoStyle: LogoStyle) extends Embroidery {

  override def drawImage(): BufferedImage = {
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

  def getAsciiArt(pixel: Pixel): Char = {
    val darkestArt = PixelAsciiArt(Pixel(0), logoStyle.darkestArt)
    logoStyle.pixelsWithArt
      .find(i => pixel.value >= i.pixel.value)
      .getOrElse(darkestArt)
      .art
      .value
  }

  private def calculatePreferredSize(width: Int, height: Int): (Int, Int) = {
    val (maxW, maxH) = (logoStyle.maxSize.width, logoStyle.maxSize.height)
    val x            = if (width < maxW) width else maxW
    val y            = if (height < maxH) height else maxH

    if (width > height) {
      val q: Float  = width.toFloat / height.toFloat
      val newHeight = (x / q).toInt
      (x * 2, newHeight)
    } else if (height > width) {
      val q: Float = height.toFloat / width.toFloat
      val newWidth = (y / q).toInt
      (newWidth * 2, y)
    } else (x, y / 2) //if height == width
  }
}

object LogoArt {
  def apply(imgPath: String, maybeLogoStyle: Either[String, LogoStyle]): Embroidery = {
    val result = for {
      logoStyle <- maybeLogoStyle
      url = LogoPath(imgPath)
      logo <- readLogo(url)
    } yield LogoArt(logo, url, logoStyle)
    result.fold(Embroidery.Empty, identity)
  }

  private def readLogo(url: LogoPath): Either[String, BufferedImage] =
    try {
      def isValid: Boolean = {
        val regex = "[^\\s]+(\\.(?i)(jpg|jpeg|png|bmp))$"
        url.value.matches(regex)
      }
      if (isValid) {
        val bufferedImage = ImageIO.read(new File(url.value))
        if (bufferedImage.getWidth == 0 || bufferedImage.getHeight == 0) Left("Width and Height should be > 0")
        else Right(bufferedImage)
      } else
        Left(s"Invalid path: $url, Embroidery supports only: jpg, jpeg, png, bmp formats.")
    } catch {
      case ex: IOException => Left(ex.getMessage)
    }
}
