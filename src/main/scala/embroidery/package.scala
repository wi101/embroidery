import java.awt.image.BufferedImage
import java.awt.{Color, Font}

package object embroidery {

  implicit class TextConversion(text: Text) {
    def toImageText: String = {
      val image = text.getImage
      val graphics2D = image.bufferedImg.createGraphics()

      val black = Color.BLACK.getRGB
      val white = Color.WHITE.getRGB

      graphics2D.drawString(text.content, 0, 0)
      val matrix = Array.ofDim[Int](image.height, image.width)
      //todo: fillMatrix with (xPos, yPos)
      ???
    }

    def getImage: Image = {
      val emptyImage = new BufferedImage(0, 0, BufferedImage.TYPE_INT_RGB)
      val graphics2D = emptyImage.createGraphics()
      
      val font = new Font("Default", Font.PLAIN, text.size)
      val metrics = graphics2D.getFontMetrics(font)
      val width = metrics.stringWidth(text.content)
      val height = metrics.getHeight

      Image(new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB),
            width = width,
            height = height)
    }
  }

}
