name := "Nomad"

version := "0.1.0"

organization := "us.troutwine"

scalaVersion := "2.9.0"

scalacOptions ++= Seq(
  "-deprecation", "-explaintypes", "-optimise"
)

publishTo := Some("troutwine.us repository" at "http://maven.troutwine.us/")

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

libraryDependencies ++= Seq(
  "com.googlecode.flyway" % "flyway-core" % "1.4.1"
  , "commons-configuration" % "commons-configuration" % "1.6"
  // JDBC access libraries. Include more and win prizes, maybe!
  , "postgresql" % "postgresql" % "9.0-801.jdbc4"
  , "mysql" % "mysql-connector-java" % "5.1.16"
  , "com.h2database" % "h2" % "1.3.155"
  // Testing
  , "org.scalatest" %% "scalatest" % "1.4.1"
  // Kindly instruct Flyway to be silent. (Everyone has their own logging
  // solution, including me. I, at least, have the decency not to _use_ it.)
  , "org.slf4j" % "slf4j-log4j12" % "1.5.6"
)
