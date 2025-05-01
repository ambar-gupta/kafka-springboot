package com.ambar.KafkaProject.json;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserConsumer {
	
	private User user;
	
	@KafkaListener(topics = "json_topic", groupId = "group_ID", errorHandler = "myErrorHandler")
	public void readMessageFromTopic(User u) {
		System.out.println("**** User Details : " + u.toString());
		this.user = u;
		throw new RuntimeException("Test exception!"); // Simulate an error
	}
	
	public User getUserDetails() {
		return user;
	}

}
