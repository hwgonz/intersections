import sbt._

object Dependencies {

  val coreScala2Dependencies = Seq(
    // Circe JSON
    "io.circe" %% "circe-core" % "0.14.0-M3",
    "io.circe" %% "circe-generic" % "0.14.0-M3",
    "io.circe" %% "circe-parser" % "0.14.0-M3",


    // Cats
    "org.typelevel" %% "cats-core" % "2.3.1",
    "org.typelevel" %% "cats-effect" % "2.3.1",

    // Priority maps
    "de.ummels" %% "scala-prioritymap" % "1.0.0"
  )

  lazy val loggingDependencies = Seq(
    "org.typelevel" %% "log4cats-core"    % "1.2.0",  // Only if you want to Support Any Backend
    "org.typelevel" %% "log4cats-slf4j"   % "1.2.0",  // Direct Slf4j Support - Recommended

    "ch.qos.logback" % "logback-classic" % "1.2.3",
    "org.slf4j" % "slf4j-api" % "1.7.30"
  )



  lazy val testDependencies = Seq(
    //"org.scalatest" %% "scalatest" % "3.2.3" % Test, //IntegrationTest,
    "org.typelevel" %% "munit-cats-effect-2" % "1.0.7" % "test",
    "org.scalameta" %% "munit" % "1.0.0-M1" % Test
  )


}
