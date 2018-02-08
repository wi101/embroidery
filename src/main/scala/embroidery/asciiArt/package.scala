package embroidery

import java.awt.Color
import java.awt.image.BufferedImage

package object asciiArt {

  def imageToPixelMatrix(bufferedImg: BufferedImage) = {
    val width = bufferedImg.getWidth
    val height = bufferedImg.getHeight
    val matrix = Array.ofDim[Pixel](height, width)
    for {
      i <- 0 until height
      j <- 0 until width
    } {
      val pixcol = new Color(bufferedImg.getRGB(j, i))
      val pixel = (((pixcol.getRed() * 0.30) + (pixcol.getBlue() * 0.59) + (pixcol.getGreen() * 0.11)))
      matrix(i).update(j, Pixel(pixel.toInt))
    }
    PixelMatrix(matrix)
  }

  def convertToAsciiArt(art: Art, matrix: PixelMatrix) = {
    val darkestArt = PixelAsciiArt(Pixel(0), art)

    matrix.pixels.foldLeft("") {
      (asciiArt, lines) =>
        asciiArt + lines.map { pixel =>
          PixelAsciiArt.pixelsWithArt.find(i => pixel.value <= i.pixel.value).getOrElse(darkestArt).art.value
        }
          .mkString + "\n"
    }
  }

}
