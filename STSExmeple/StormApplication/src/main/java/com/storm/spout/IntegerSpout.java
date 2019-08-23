package com.storm.spout;

import java.util.Map;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

public class IntegerSpout extends BaseRichSpout{
	private SpoutOutputCollector spoutOutputCollector;
	private Integer index = 0;
	public void nextTuple() {
		if (index < 100 ) {
			this.spoutOutputCollector.emit(new Values(index));
			index++;			
		}
	}

	public void open(Map config, TopologyContext arg1, SpoutOutputCollector spoutOutputCollector) {
		this.spoutOutputCollector = spoutOutputCollector;
	}

	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		// TODO Auto-generated method stub
		declarer.declare(new Fields("Field"));
	}

}
