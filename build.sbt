
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "org.test"
ThisBuild / scalaVersion := "2.12.12"

lazy val root = (project in file("."))
  .settings(
    name := "intersections",
    assembly / mainClass := Some("org.test.intersections.Intersections"),
    scalacOptions ++= Seq(
        "-deprecation",
        "-feature",
        "-unchecked",
        "-language:postfixOps",
        "-Xlint"
    ),

    assembly / assemblyJarName := "intersections.jar",
    libraryDependencies ++= Dependencies.coreScala2Dependencies
      ++ Dependencies.loggingDependencies ++ Dependencies.testDependencies
  )



