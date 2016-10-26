name := "scala-test-learning"

version := "1.0"

scalaVersion := "2.11.8"


libraryDependencies += "org.seleniumhq.selenium" % "selenium-java" % "2.35.0" % "test"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.0"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % "test"
parallelExecution in Test := true


resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"
