import java.awt.Color

package object embroidery {

  implicit class TextConversion(text: Text) {
    def convertTextToASCIIArt: String = {
      val matrix = text.toImage.toMatrixOfPixels()
      val white = Color.WHITE.getRGB
      matrix.foldLeft(""){(lineStr, lines) =>
        lineStr + lines.map{pixel => if (pixel.value == white) text.art else ' '}.mkString + "\n"
      }
    }
  }
}
