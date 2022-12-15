
# HDFS mini cluster for testing

## build
`sbt Docker / publish`

Create docker image based on alpine with java 8 and simple installation HDFS Minicluster ver. 3.3.1

## deploy
`docker run --rm -p 8020:8020 -p 9864:9864 -p 9866:9866 -p 9867:9867  io.mitgard/hdfs-minicluster:0.1.0-SNAPSHOT`