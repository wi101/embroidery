name := "embroidery"
version := "0.1"
scalaVersion := "2.13.3"
onLoadMessage := {
  import scala.Console._
  s"$WHITE_B$BOLD$BLACK /-----------------------\\ $RESET\n" +
    s"$WHITE_B$BOLD$BLACK    E M B R O I D E R Y$BLACK    $RESET\n" +
    s"$WHITE_B$BOLD$BLACK /-----------------------\\ $RESET\n"
}
