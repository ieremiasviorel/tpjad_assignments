name := """report-demo"""
organization := "com.tpjad"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.1"

libraryDependencies ++= Seq(
  guice,
  javaWs,
  "com.typesafe.play" %% "play-ws" % "2.8.0"
)
