lazy val commonSetting = Seq(
  version := "1.0",
  scalaVersion := "2.11.7",
  organization := "net.iceyang"
)

libraryDependencies ++= {
  val akkaV = "2.3.9"
  val sprayV = "1.3.3"
  Seq(
    "com.github.nscala-time" %%  "nscala-time"   % "2.6.0",
    "joda-time"              %   "joda-time"     % "2.9.1",
    "org.reactivemongo"      %%  "reactivemongo" % "0.11.7",
    "io.spray"               %%  "spray-can"     % sprayV,
    "io.spray"               %%  "spray-routing" % sprayV,
    "com.typesafe.akka"      %%  "akka-actor"    % akkaV
  )
}

lazy val root = (project in file(".")).
  settings(commonSetting: _*).
  settings(
    name := "cgcenter"
  )
