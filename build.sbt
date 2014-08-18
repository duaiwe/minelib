name := "minelib"

organization := "org.a2plab"

version := "0.2-SNAPSHOT"

scalaVersion := "2.11.1"

S3Resolver.defaults

libraryDependencies ++= Seq(
	"org.scala-lang.modules" %% "scala-xml" % "1.0.2",
	"org.scala-tools.sbinary" %% "sbinary" % "0.4.3-SNAPSHOT" withSources()
)

publishTo := {
	val prefix = if (isSnapshot.value) "snapshots" else "releases"
	Some(s3resolver.value("Rampant I/O " + prefix + " S3 bucket", s3("rampant.io." + prefix)))
}

resolvers ++= Seq[Resolver](
	s3resolver.value("Releases resolver", s3("rampant.io.releases")),
	s3resolver.value("Snapshots resolver", s3("rampant.io.snapshots"))
)
