import Dependencies._
import sbt.Keys.scalaVersion

lazy val root = (project in file("."))
  .settings(
    name := "shopping-cart",
    organization := "com.example",
    scalaVersion := "2.13.1",
    version := "1.0",
    libraryDependencies += scalaTest % Test,
    scalafmtOnCompile.in(ThisBuild) := true
//    coverageMinimum := 90,
//    coverageFailOnMinimum := true
  )
