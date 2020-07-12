package embroidery

final case class Art(value: Char) extends AnyVal
final case class Pixel(value: Int) extends AnyVal
final case class URL private (value: String) extends AnyVal {
  def validate: Boolean = {
    val regex = "[^\\s]+(\\.(?i)(jpg|jpeg|png|bmp))$"
    value.matches(regex)
  }
}
