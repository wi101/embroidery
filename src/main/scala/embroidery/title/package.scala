package embroidery

package object title {
  def asciiArt(str: String): String =
    TitleArt(str, TitleStyle.default).toAsciiArt

  def asciiArt(str: String, art: Char): String =
    TitleArt(str, TitleStyle(Art(art))).toAsciiArt

  def asciiArt(str: String, art: Char, spaces: Int): String =
    TitleArt(str, TitleStyle(Art(art), spaces)).toAsciiArt

  def asciiArt(str: String, spaces: Int): String =
    TitleArt(str, TitleStyle(spaces = spaces)).toAsciiArt
}
