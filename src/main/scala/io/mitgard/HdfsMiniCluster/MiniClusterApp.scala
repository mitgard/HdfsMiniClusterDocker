package io.mitgard.HdfsMiniCluster

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.hdfs.DFSConfigKeys._
import org.apache.hadoop.hdfs.MiniDFSCluster


object MiniClusterApp {

  def main(args: Array[String]): Unit = {

    System.setProperty("user.name", "r.iksanov")
    val conf = new Configuration()
    conf.set(MiniDFSCluster.HDFS_MINIDFS_BASEDIR, "/tmp")
    conf.set("dfs.datanode.data.dir.perm", "755")
    conf.set("fs.permission.umask-mode", "0077")

    conf.set(DFS_DATANODE_HOST_NAME_KEY, "0.0.0.0")
    conf.set(DFS_DATANODE_ADDRESS_KEY, DFS_DATANODE_ADDRESS_DEFAULT)
    conf.set(DFS_NAMENODE_RPC_ADDRESS_KEY, "0.0.0.0:8020")
    conf.set("dfs.namenode.rpc-bind-host", "0.0.0.0")
    conf.set("dfs.permissions", "false")
    conf.set("hadoop.security.authentication", "simple")
    conf.set("hadoop.security.authorization", "false")

    new MiniDFSCluster.Builder(conf)
      .nameNodePort(8020)
      .nameNodeHttpPort(9000)
      .useConfiguredTopologyMappingClass(true)
      .checkDataNodeAddrConfig(true)
      .checkDataNodeHostConfig(true)
      .build()
    Thread.currentThread().join()

  }
}
