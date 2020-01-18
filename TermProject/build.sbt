organization := "com.tpjad"

name := "play-file-manager"

scalaVersion := "2.12.6"

version := "1.0-SNAPSHOT"

val appDependencies = Seq(
  javaJdbc,
  cacheApi,
  ehcache,
  javaWs,
  "com.feth" %% "play-authenticate" % "0.9.0-SNAPSHOT",
  "mysql" % "mysql-connector-java" % "5.1.36"
)

// add resolver for easymail snapshots
resolvers += Resolver.sonatypeRepo("snapshots")

lazy val root = (project in file("."))
  .enablePlugins(PlayJava, PlayEbean)
  .settings(
    libraryDependencies ++= appDependencies
  )
