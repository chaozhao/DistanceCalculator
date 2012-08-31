import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "HIT3311"
    val appVersion      = "0.1"

    val appDependencies = Seq(
      // Add your project dependencies here,
      "postgresql" % "postgresql" % "9.1-902.jdbc4"

    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      // Add your own project settings here      
    )

}
