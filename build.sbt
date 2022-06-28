val scala2Version = "2.12.4"
//val scala2Version = "2.13.8"
// "-Ymacro-annotations",

lazy val root = (project in file("."))
  .settings(
    name := "intersections", resolvers += "jitpack".at("https://jitpack.io"),
    organization := "org.test.intersection",
    version := "0.0.1-SNAPSHOT",
    scalaVersion := scala2Version,
    scalacOptions ++= Seq(
        "-deprecation",
    ),
    assembly / assemblyMergeStrategy := {
      case PathList("META-INF", xs @ _*) => MergeStrategy.discard
      case x =>
          val oldStrategy = (assembly / assemblyMergeStrategy).value
          oldStrategy(x)
    },
    assembly / assemblyJarName := "intersections.jar",
    libraryDependencies ++= Dependencies.coreScala2Dependencies
      ++ Dependencies.loggingDependencies ++ Dependencies.testDependencies
  )



