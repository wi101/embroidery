package embroidery.asciiArt

package object title {
  def printWithArt(str: String,
                   style: TitleStyle = TitleStyle.default): Unit = {
    val titleArt = TitleArt(Title(str), style).toAsciiArt
    println(titleArt)
  }
  def printWithArt(str: String, art: Char): Unit = {
    val titleArt = TitleArt(Title(str), TitleStyle(Art(art))).toAsciiArt
    println(titleArt)
  }
  def printWithArt(str: String, art: Char, spaces: Int): Unit = {
    val titleArt = TitleArt(Title(str), TitleStyle(Art(art), spaces)).toAsciiArt
    println(titleArt)
  }
  def printWithArt(str: String, spaces: Int): Unit = {
    val titleArt = TitleArt(Title(str), TitleStyle(spaces = spaces)).toAsciiArt
    println(titleArt)
  }

  def asciiArt(str: String, style: TitleStyle = TitleStyle.default): String =
    TitleArt(Title(str), style).toAsciiArt
  def asciiArt(str: String, art: Char): String =
    TitleArt(Title(str), TitleStyle(Art(art))).toAsciiArt
  def asciiArt(str: String, art: Char, spaces: Int): String =
    TitleArt(Title(str), TitleStyle(Art(art), spaces)).toAsciiArt
  def asciiArt(str: String, spaces: Int): Unit = {
    TitleArt(Title(str), TitleStyle(spaces = spaces)).toAsciiArt
  }
}
