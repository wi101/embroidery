name := "embroidery"

inThisBuild(
  List(
    organization := "com.github.wi101",
    homepage := Some(url("https://github.com/wi101/embroidery")),
    licenses := List("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")),
    developers := List(Developer("wi101", "Wiem Zine Elabidine", "wiemzin@gmail.com", url("https://github.com/wi101")))
  )
)

onLoadMessage := {
  import scala.Console._
  s"$WHITE_B$BOLD$BLACK /-----------------------\\ $RESET\n" +
    s"$WHITE_B$BOLD$BLACK    E M B R O I D E R Y $BLACK$RESET\n" +
    s"$WHITE_B$BOLD$BLACK /-----------------------\\ $RESET\n"
}

scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-feature",
  "-Xlint"
)
scalafmtOnCompile := true

crossScalaVersions := List("2.12.10", "2.13.4")

// scalafix; run with `scalafixEnable` followed by `scalafixAll`
ThisBuild / scalafixDependencies += "com.github.liancheng" %% "organize-imports" % "0.4.3"
