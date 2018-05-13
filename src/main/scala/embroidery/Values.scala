package embroidery

case class Art(value: Char) extends AnyVal
case class Pixel(value: Int) extends AnyVal

case class URL(value: String) extends AnyVal {
  def validate: Boolean = {
    val regex = "[^\\s]+(\\.(?i)(jpg|jpeg|png|bmp))$"
    value.matches(regex)
  }
}
