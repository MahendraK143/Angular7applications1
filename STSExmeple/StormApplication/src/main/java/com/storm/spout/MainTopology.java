package com.storm.spout;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.topology.TopologyBuilder;

public class MainTopology {
	public static void main(String[] args) {
		TopologyBuilder topologyBuilder = new TopologyBuilder();
		topologyBuilder.setSpout("IntegerSpout", new IntegerSpout());
		topologyBuilder.setBolt("MultiplierBolt", new MultiplierBolt()).shuffleGrouping("IntegerSpout");
		System.out.println("tttttttttt");
		Config config = new Config();
		//config.setDebug(true);
		
		// localmode / remotemode
		LocalCluster localCluster = new LocalCluster();
		
		try {
			localCluster.submitTopology("HelloTopology", config, topologyBuilder.createTopology());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			localCluster.shutdown();
		}
	}
}
