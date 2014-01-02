import sbt._
import Keys._

object CoreBuild extends Build {
	lazy val root = Project("stringmetric", file("."),
		settings = Defaults.defaultSettings ++ Seq(
			organization := "com.rockymadden.stringmetric",
			name := "stringmetric",
			version := "0.26.1",
			scalaVersion := "2.10.3",
			resolvers ++= Seq(DefaultMavenRepository),
			publishTo := Some("Sonatype" at "https://oss.sonatype.org/service/local/staging/deploy/maven2"),
			publishMavenStyle := true,
			credentials += Credentials(Path.userHome / ".ivy2" / ".credentials"),
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
				</developers>)
	).aggregate(core, cli)

	lazy val core: Project = Project("core", file("core"),
		settings = (root.settings: Seq[sbt.Def.Setting[_]]) ++ Seq(
			name := "stringmetric-core",
			libraryDependencies ++= Seq(
				"junit" % "junit" % "4.11" % "test",
				"org.scalatest" %% "scalatest" % "2.0.M5b" % "test"
			)
		)
	)

	lazy val cli: Project = Project("cli", file("cli"),
		settings = (root.settings: Seq[sbt.Def.Setting[_]]) ++ Seq(
			name := "stringmetric-cli",
			libraryDependencies ++= Seq(
				"junit" % "junit" % "4.11" % "test",
				"org.scalatest" %% "scalatest" % "2.0.M5b" % "test"
			)
		)
	).dependsOn(core)
}
