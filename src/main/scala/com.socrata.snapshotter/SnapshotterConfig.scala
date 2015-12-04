package com.socrata.snapshotter

import com.socrata.curator.{CuratedClientConfig, DiscoveryBrokerConfig}
import com.typesafe.config.ConfigFactory

object SnapshotterConfig {
  lazy val config = ConfigFactory.load().getConfig("com.socrata")

  lazy val port = config.getInt("snapshotter.port")
  lazy val gzipBufferSize = config.getString("snapshotter.gzip-buffer-size").toInt
  lazy val uploadPartSize = config.getString("aws.upload-part-size").toInt

  lazy val broker = new DiscoveryBrokerConfig(config, "broker")
  lazy val client = new CuratedClientConfig(config, "upstream")

  lazy val awsBucketName = config.getString("aws.bucket-name")
}