import sbt._
import Keys._

object Common {
	def name = "stringmetric"
	def organization = "com.rockymadden.stringmetric"
	def scalaVersion = "2.10.3"
	def version = "0.26.1"
}

object CoreBuild extends Build {
	lazy val root = Project(Common.name, file(".")).aggregate(core, cli)

	lazy val core: Project = Project("core", file("core"),
		settings = Defaults.defaultSettings ++ Seq(
			organization := Common.organization,
			name := Common.name + "-core",
			version := Common.version,
			scalaVersion := Common.scalaVersion,
			resolvers ++= Seq(DefaultMavenRepository),
			libraryDependencies ++= Seq(
				"junit" % "junit" % "4.11" % "test",
				"org.scalatest" %% "scalatest" % "2.0.M5b" % "test"
			)
		)
	)

	lazy val cli: Project = Project("cli", file("cli"),
		settings = Defaults.defaultSettings ++ Seq(
			organization := Common.organization,
			name := Common.name + "-cli",
			version := Common.version,
			scalaVersion := Common.scalaVersion,
			resolvers ++= Seq(DefaultMavenRepository),
			libraryDependencies ++= Seq(
				"junit" % "junit" % "4.11" % "test",
				"org.scalatest" %% "scalatest" % "2.0.M5b" % "test"
			)
		)
	).dependsOn(core)
}
