inThisBuild(
  List(
    organization := "com.github.wi101",
    homepage := Some(url("https://github.com/wi101/embroidery")),
    licenses := List("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")),
    developers := List(Developer("wi101", "Wiem Zine Elabidine", "wiemzin@gmail.com", url("https://github.com/wi101"))),
    scalaVersion := "2.13.10",
    semanticdbEnabled := true,
    semanticdbVersion := scalafixSemanticdb.revision,
    scalafixDependencies += "com.github.liancheng" %% "organize-imports" % "0.6.0",
    scalafmtOnCompile := true
  )
)

addCommandAlias("fix", "scalafixAll")

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

lazy val root = (project in file(".")).settings(name := "embroidery").aggregate(core, examples)
lazy val core = project in file("core")
lazy val examples = (project in file("examples")).settings(publish / skip := true).dependsOn(core)
