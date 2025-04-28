package com.ambar.KafkaProject.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
	
	private final String topic = "DEMO_TOPIC";
	
	private KafkaTemplate<String, String> template;
	
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.template = kafkaTemplate;
    }
	
	public void sendMessage(String message) {
		template.send(topic, message);
	}

}
