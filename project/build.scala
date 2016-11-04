import sbt._
import Keys._

object CoreBuild extends Build {
	lazy val root = Project("stringmetric", file("."),
		settings = Defaults.defaultSettings ++ Seq(
			//credentials += Credentials(Path.userHome / ".ivy2" / ".credentials"),
			name := "stringmetric",
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
			publishTo := Some("Sonatype" at "https://oss.sonatype.org/service/local/staging/deploy/maven2"),
			resolvers ++= Seq(DefaultMavenRepository),
			scalaVersion := "2.12.0",
			crossScalaVersions := Seq("2.12.0", "2.11.1", "2.10.4"),
			crossVersion := CrossVersion.binary,
			version := "0.27.5"
		)
	).aggregate(core, cli)

	lazy val core: Project = Project("core", file("core"),
		settings = (root.settings: Seq[sbt.Def.Setting[_]]) ++ Seq(
			libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "3.8.6" % "test"),
			name := "stringmetric-core"
		)
	)

	lazy val cli: Project = Project("cli", file("cli"),
		settings = (root.settings: Seq[sbt.Def.Setting[_]]) ++ Seq(
			libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "3.8.6" % "test"),
			name := "stringmetric-cli"
		)
	).dependsOn(core)
}
