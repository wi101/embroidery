package embroidery

import java.awt.Color
import java.awt.image.BufferedImage

import scala.Console.{ RED, RESET }
import scala.util.Try

abstract class Embroidery { self =>

  protected def drawImage(): BufferedImage

  private def toPixelMatrix: PixelMatrix = {
    val bufferedImg = drawImage()
    val width       = bufferedImg.getWidth
    val height      = bufferedImg.getHeight
    val matrix      = Array.ofDim[Pixel](height, width)
    for {
      i <- 0 until height
      j <- 0 until width
    } {
      // if the background is transparent we must convert it to white color background
      val isTransparent = (bufferedImg.getRGB(j, i) & 0xff000000) == 0
      if (isTransparent)
        bufferedImg.setRGB(j, i, Color.white.getRGB & 0x00ffffff)

      val pixelColor = new Color(bufferedImg.getRGB(j, i))

      // calculate the brightness
      val pixel = (pixelColor.getRed + pixelColor.getBlue + pixelColor.getGreen) / 3
      matrix(i).update(j, Pixel(pixel.toInt))
    }
    PixelMatrix(matrix)
  }

  protected def getAsciiArt(pixel: Pixel): Char

  def toAsciiArt: String =
    self match {
      case Embroidery.Empty(reason) =>
        s"$RED<error>$RESET Input couldn't be converted to ASCII Art. Reason: $reason"

      case _ =>
        Try {
          val matrix = toPixelMatrix
          matrix.pixels.foldLeft("") { (asciiArt, lines) =>
            asciiArt + lines.map(getAsciiArt).mkString + System.getProperty("line.separator")
          }
        }.recover { case err => s"$RED<error>$RESET Input couldn't be converted to ASCII Art. Reason: $err." }
          .getOrElse(s"$RED<error>$RESET Unexpected error!")
    }
}

object Embroidery {

  final case class Empty(reason: String) extends Embroidery {
    // Draw an empty image for an empty image.
    override protected def drawImage(): BufferedImage =
      new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_BINARY)

    // Use an empty ascii char
    override protected def getAsciiArt(pixel: Pixel): Char = '\u0000'
  }
}
