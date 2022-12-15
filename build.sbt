ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val hadoopVersion = "3.3.1"
lazy val log4jVersion = "2.0.5"

lazy val root = (project in file("."))
  .settings(
    name := "HdfsMiniClusterDocker",
    libraryDependencies ++= Seq(
      "org.apache.hadoop" % "hadoop-hdfs" % hadoopVersion,
      "org.apache.hadoop" % "hadoop-client" % hadoopVersion,
      "org.apache.hadoop" % "hadoop-hdfs" % hadoopVersion classifier "tests",
      "org.apache.hadoop" % "hadoop-common" % hadoopVersion,
      "org.apache.hadoop" % "hadoop-common" % hadoopVersion classifier "tests",
      "org.slf4j" % "slf4j-api" % log4jVersion,
      "org.slf4j" % "slf4j-log4j12" % log4jVersion,


    )
  )
  .enablePlugins(
    JavaAppPackaging,
    DockerPlugin
  )

Compile / mainClass := Some("io.mitgard.HdfsMiniCluster.MiniClusterApp")

Docker / packageName := "hdfs-minicluster"
Docker / dockerUsername := Some("mitgard")
dockerBaseImage := "rawmind/alpine-jvm8:1.8.181-1"

dockerExposedPorts := Seq(8020, 9864, 9866, 9867)
Docker / daemonUser := "tester"
