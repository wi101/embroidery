import java.awt.image.BufferedImage
import java.awt.{Color, Font}

package object embroidery {

  implicit class TextConversion(text: Text) {
    def toImageText: String = {
      val img = text.toImage
      val matrix = text.toImage.toMatrixOfPixels()
      val white = Color.WHITE.getRGB
      matrix.foldLeft(""){(lineStr, lines) =>
        lineStr + lines.map{pixel => if (pixel.value == white) text.art else ' '}.mkString + "\n"
      }
    }
  }
}
