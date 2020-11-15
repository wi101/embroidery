package embroidery.asciiArt
package logo

object LogoExamples extends App {
  println(logo.asciiArt("src/test/images/cat2.png"))
  println(logo.asciiArt("src/test/images/cat.png"))
  println(logo.asciiArt("src/test/images/smiley.png"))
  println(logo.asciiArt("src/test/images/scala.jpg"))

  // invalid
  println(logo.asciiArt("src/test/images/play.png", 10, 10))

  println(logo.asciiArt("src/test/images/akka.png"))
  println(logo.asciiArt("src/test/images/fleur.jpg", 50, 30))
  println(logo.asciiArt(
    "src/test/images/transparent.png")) //check an icon with transparent background
  println(logo.asciiArt("src/test/images/scalaz.png"))
  println(
    logo.asciiArt("src/test/images/pikachu.png", 50, 50))

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
    "src/test/images/scala.jpg",
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
