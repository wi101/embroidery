package embroidery
package title

// Title
final case class Title private (text: String, style: TitleStyle)

object Title {
  val MaxLength: Int = 20
  def apply(str: String, style: TitleStyle): Either[String, Title] = {
    val text = finalText(str, style.spaces)
    if (text.length <= MaxLength) Right(new Title(text, style))
    else Left(s"The title shouldn't be too long, maximum supported length is $MaxLength")
  }

  private def finalText(text: String, spaces: Int): String =
    text.mkString(" " * spaces)
}

/**
  * The style of the title
  * @param art the art character to be used.
  * @param spaces between each character.
  */
final case class TitleStyle(art: Art = Art('#'), spaces: Int = 0) {
  // currently the font size couldn't be modified
  val fontSize: Int = 12
}
object TitleStyle {
  val default: TitleStyle = new TitleStyle()
}
