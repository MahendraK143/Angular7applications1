package com.kafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.model.User;

@Service
public class KafkaConsumer {
	@KafkaListener(topics = {"test"}, groupId = "group_id")
	public void consumer(String message){
		System.out.println("Consumer Message:"+message);
	}
	@KafkaListener(topics = {"User_Json"}, groupId = "group_json", containerFactory = "userKafkaListenerContainerFactory")
	public void consumerJson(User user){
		System.out.println("Consumer Message User:"+user);
	}

}
