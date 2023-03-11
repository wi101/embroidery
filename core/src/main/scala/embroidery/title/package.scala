package embroidery

package object title {
  def asciiArt(title: String): String =
    TitleArt(title, TitleStyle.default).toAsciiArt

  def asciiArt(title: String, art: Char): String =
    TitleArt(title, TitleStyle(Art(art))).toAsciiArt

  def asciiArt(title: String, art: Char, spaces: Int): String =
    TitleArt(title, TitleStyle(Art(art), spaces)).toAsciiArt

  def asciiArt(title: String, spaces: Int): String =
    TitleArt(title, TitleStyle(spaces = spaces)).toAsciiArt
}
