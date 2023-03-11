import embroidery.{ Art, Pixel, PixelAsciiArt, logo }

object LogoExamples extends App {
  println(logo.asciiArt("examples/src/images/cat2.png"))
  println(embroidery.ImagePath("examples/src/images/cat.png").toAsciiArt)
  println(logo.asciiArt("examples/src/images/smiley.png"))
  println(logo.asciiArt("examples/src/images/scala.jpg"))

  // invalid
  println(logo.asciiArt("examples/src/images/play.png", 5, 5))

  println(logo.asciiArt("examples/src/images/akka.png"))
  println(logo.asciiArt("examples/src/images/fleur.jpg", 20, 20))
  println(logo.asciiArt("examples/src/images/transparent.png")) // check an icon with transparent background
  println(logo.asciiArt("examples/src/images/scalaz.png"))
  println(logo.asciiArt("examples/src/images/pikachu.png", 50, 50))

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
    "examples/src/test/images/scala.jpg",
    pixelsWithArt,
    100,
    50
  )
  val scala = img.flatMap(c =>
    if (c != ' ' && c != '\n')
      Console.RED + c.toString + Console.RESET
    else c.toString
  )
  println(scala)
}
