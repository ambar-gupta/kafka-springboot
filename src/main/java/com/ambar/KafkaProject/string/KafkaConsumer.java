package com.ambar.KafkaProject.string;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	
	private String lastMessage = "";
		
	@KafkaListener(topics = "DEMO_TOPIC", groupId = "group_id")
	public void readMessageFromTopic(String message) {
		System.out.println("**** Consumed message : " + message);
		this.lastMessage = message;
	}
	
	public String getMessage() {
		return lastMessage;
	}

}
