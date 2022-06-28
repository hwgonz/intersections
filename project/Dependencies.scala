import sbt._

object Dependencies {

  val coreScala2Dependencies = Seq(
    // Circe JSON
    "io.circe" %% "circe-core" % "0.14.0-M3",
    "io.circe" %% "circe-generic" % "0.14.0-M3",
    "io.circe" %% "circe-generic-extras" % "0.13.0",
    "io.circe" %% "circe-literal" % "0.14.0-M3",
    "io.circe" %% "circe-optics" % "0.13.0",
    "io.circe" %% "circe-json-schema" % "0.1.0",
    "io.circe" %% "circe-parser" % "0.14.0-M3",

    "com.beachape" %% "enumeratum-circe" % "1.7.0",

    // Cats
    "org.typelevel" %% "cats-core" % "2.3.1",
    "org.typelevel" %% "cats-effect" % "2.3.1",

    // Configuration
    "com.typesafe" % "config" % "1.4.1",
    "com.github.pureconfig" %% "pureconfig" % "0.14.0",
    "com.github.pureconfig" %% "pureconfig-cats-effect" % "0.14.0",
    "com.github.pureconfig" %% "pureconfig-enum" % "0.14.0",

    // Priority maps
    "de.ummels" %% "scala-prioritymap" % "1.0.0"
  )

  lazy val loggingDependencies = Seq(
    "org.typelevel" %% "log4cats-core"    % "1.2.0",  // Only if you want to Support Any Backend
    "org.typelevel" %% "log4cats-slf4j"   % "1.2.0",  // Direct Slf4j Support - Recommended

    "ch.qos.logback" % "logback-classic" % "1.2.3",
    "org.slf4j" % "slf4j-api" % "1.7.30"
  )

  val apiDependencies = Seq(
    // http server dependencies
    "com.softwaremill.sttp.tapir" %% "tapir-core" % "0.17.6",
    "com.softwaremill.sttp.tapir" %% "tapir-json-circe" % "0.17.6",
    "com.softwaremill.sttp.tapir" %% "tapir-openapi-docs" % "0.17.6",
    "com.softwaremill.sttp.tapir" %% "tapir-openapi-circe-yaml" % "0.17.6",
    "com.softwaremill.sttp.tapir" %% "tapir-http4s-server" % "0.17.6",
    "com.softwaremill.sttp.tapir" %% "tapir-swagger-ui-http4s" % "0.17.6",
    "com.softwaremill.sttp.tapir" %% "tapir-sttp-client" % "0.17.6",
    "com.softwaremill.sttp.client3" %% "http4s-backend" % "3.0.0",
    "com.softwaremill.sttp.client" %% "core" % "2.2.9",
    "com.softwaremill.sttp.client3" %% "core" % "3.0.0-RC11",
    "org.http4s" %% "http4s-blaze-client" % "0.21.15",
    "org.http4s" %% "http4s-blaze-server" % "0.21.15",
    "org.http4s" %% "http4s-ember-client" % "0.21.33",
    "org.http4s" %% "http4s-circe" % "0.21.15",
  )

  lazy val streamingDependencies = Seq(
    "com.github.fd4s" %% "fs2-kafka" % "2.0.0-M1",
  )

  lazy val testDependencies = Seq(
    "org.scalatest" %% "scalatest" % "3.2.3" % Test, //IntegrationTest,
  )

  lazy val databaseDependencies = Seq(
    // Database
    "org.tpolecat" %% "doobie-core" % "0.10.0",
    "org.tpolecat" %% "doobie-hikari" % "0.10.0",
    "mysql" % "mysql-connector-java" % "8.0.20",
    "com.github.cb372" %% "cats-retry" % "2.1.1",
  )


}
