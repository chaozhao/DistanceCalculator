import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "HIT3311"
    val appVersion      = "0.1"

    val appDependencies = Seq(
      // Add your project dependencies here,
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      // Add your own project settings here      
    )

}