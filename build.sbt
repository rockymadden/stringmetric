import sbt._
import Keys._

val Specs2Version = "3.9.1"

val commonSettings = Seq(
  version := "0.27.5-SNAPSHOT",
  credentials += Credentials(Path.userHome / ".ivy2" / ".credentials"),
  organization := "com.rockymadden.stringmetric",
  pomExtra :=
    <url>http://rockymadden.com/stringmetric/</url>
      <licenses>
        <license>
          <name>MIT</name>
          <distribution>repo</distribution>
        </license>
      </licenses>
      <scm>
        <url>git@github.com:rockymadden/stringmetric.git</url>
        <connection>scm:git:git@github.com:rockymadden/stringmetric.git</connection>
      </scm>
      <developers>
        <developer>
          <id>rockymadden</id>
          <name>Rocky Madden</name>
          <url>http://rockymadden.com/</url>
        </developer>
      </developers>,
  publishMavenStyle := true,
  publishTo := Some(
    "Sonatype" at "https://oss.sonatype.org/service/local/staging/deploy/maven2"),
  resolvers ++= Seq(DefaultMavenRepository),
  scalaVersion := "2.11.11",
  crossScalaVersions := Seq("2.12.3", "2.11.11", "2.10.4")
)

lazy val stringmetric = project
  .in(file("."))
  .settings(commonSettings)
  .settings( name := "stringmetric")
  .aggregate(core.jvm, core.js, cli)

lazy val core = crossProject
  .crossType(CrossType.Pure)
  .in(file("core"))
  .settings(commonSettings)
  .settings(
    name := "stringmetric-core"
  )
  .jvmSettings(
    libraryDependencies ++= Seq(
      "org.specs2" %% "specs2-junit" % Specs2Version % "test")
  )

lazy val coreJs = core.js

lazy val coreJvm = core.jvm

lazy val cli: Project = project
  .in(file("cli"))
  .settings(commonSettings)
  .settings(
    libraryDependencies ++= Seq(
      "org.specs2" %% "specs2-junit" % Specs2Version % "test"),
    name := "stringmetric-cli"
  )
  .dependsOn(core.jvm)
