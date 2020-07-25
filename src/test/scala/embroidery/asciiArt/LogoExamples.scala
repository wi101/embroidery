package embroidery.asciiArt

object LogoExamples extends App {
  logo.printWithArt("src/test/scala/embroidery/asciiArt/images/cat2.png") //443 * 720

  logo.printWithArt("src/test/scala/embroidery/asciiArt/images/cat.png") //225 * 225
  logo.printWithArt("src/test/scala/embroidery/asciiArt/images/smiley.png") //720 * 720

  logo.printWithArt("src/test/scala/embroidery/asciiArt/images/scala.jpg") //800 * 237
  logo.printWithArt("src/test/scala/embroidery/asciiArt/images/play.png") //511 * 231
  logo.printWithArt("src/test/scala/embroidery/asciiArt/images/akka.png") //350 * 144
  logo.printWithArt("src/test/scala/embroidery/asciiArt/images/fleur.jpg") //500 * 383
  logo.printWithArt("src/test/scala/embroidery/asciiArt/images/transparent.png") //check an icon with transparent background
  logo.printWithArt("src/test/scala/embroidery/asciiArt/images/scalaz.png")
  logo.printWithArt("src/test/scala/embroidery/asciiArt/images/pikachu.png")

  val pixelsWithArt: List[PixelAsciiArt] = List(
    // Brightest:255 ----> Darkest:0
    PixelAsciiArt(Pixel(255), Art(' ')),
    PixelAsciiArt(Pixel(230), Art('.')),
    PixelAsciiArt(Pixel(220), Art(',')),
    PixelAsciiArt(Pixel(210), Art('°')),
    PixelAsciiArt(Pixel(200), Art('²')),
    PixelAsciiArt(Pixel(190), Art('*')),
    PixelAsciiArt(Pixel(180), Art('^')),
    PixelAsciiArt(Pixel(170), Art('~')),
    PixelAsciiArt(Pixel(150), Art('/')),
    PixelAsciiArt(Pixel(140), Art('|')),
    PixelAsciiArt(Pixel(130), Art('s')),
    PixelAsciiArt(Pixel(120), Art('q')),
    PixelAsciiArt(Pixel(90), Art('µ')),
    PixelAsciiArt(Pixel(70), Art('@')),
    PixelAsciiArt(Pixel(0), Art('#'))
  )

  val img = logo.asciiArt(
    "src/test/scala/embroidery/asciiArt/images/scala.jpg",
    pixelsWithArt,
    100,
    50
  )
  val scala = img.flatMap(
    c =>
      if (c != ' ' && c != '\n')
        Console.RED + c.toString + Console.RESET
      else c.toString
  )
  println(scala)
}
