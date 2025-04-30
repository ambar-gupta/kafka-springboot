package com.ambar.KafkaProject.json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserProducer {
	
	private static String topic = "json_topic";
	
	@Autowired
	private KafkaTemplate<String, User> producer;
	
	public void sendMessageToQueue(User user) {
		producer.send(topic, "employee", user);
	}

}
