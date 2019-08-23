package com.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.model.User;

@RestController
@RequestMapping("kafka")
public class UserResource {
	private static final String TOPIC = "test";
	private static final String TOPIC_JSON = "User_Json";
	@Autowired
	public KafkaTemplate<String, User> kafkaTemplate; 
	@GetMapping("publish/{msg}")
	public String post(@PathVariable("msg") String msg){
		User user = new User();
		user.setId(1);
		user.setName("Mahendra");
		user.setDescription("Love you!");
		if(msg.equalsIgnoreCase("json"))
			kafkaTemplate.send(TOPIC_JSON,user);
		else 
			kafkaTemplate.send(TOPIC,user);
		return "Msg Published successfylly....";
	}
}
