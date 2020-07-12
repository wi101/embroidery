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
  logo.printWithArt("src/test/scala/embroidery/asciiArt/images/zio.png")
}
