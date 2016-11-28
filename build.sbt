lazy val root = (project in file(".")).
  settings(
    name := "akka-http-server",
    version := "0.1",
    scalaVersion := "2.11.8"
  )

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http" % "10.0.0",
  "com.typesafe.akka" %% "akka-http-core" % "10.0.0"
)

javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")

packAutoSettings
