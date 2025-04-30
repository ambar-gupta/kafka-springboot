package com.ambar.KafkaProject.shared;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ambar.KafkaProject.json.User;
import com.ambar.KafkaProject.json.UserConsumer;
import com.ambar.KafkaProject.json.UserProducer;
import com.ambar.KafkaProject.string.KafkaConsumer;
import com.ambar.KafkaProject.string.KafkaProducer;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {
	
	private KafkaProducer kafkaProdcuer;
	private KafkaConsumer kafkaConsumer;
	
    private UserProducer producer;
    private UserConsumer consumer;

    // Constructor Injection for KafkaProducer, KafkaConsumer, UserProducer, and UserConsumer
    public KafkaController(KafkaProducer kafkaProducer, KafkaConsumer kafkaConsumer, 
                           UserProducer producer, UserConsumer consumer) {
        this.kafkaConsumer = kafkaConsumer;
        this.kafkaProdcuer = kafkaProducer;
        this.producer = producer;
        this.consumer = consumer;
    }
	
	@PostMapping("/produce/{message}")
	public String sendMessageToQueue(@PathVariable String message) {
		kafkaProdcuer.sendMessage(message);
		return "Message Sent to kafka topic";
	}
	
	@GetMapping("/consume")
	public String readMessageFromQueue() {
		String message = kafkaConsumer.getMessage();
		return message;
	}
	
	@PostMapping("/produce/json")
	public String sendJsonMessageToQueue(@RequestBody User user) {
		producer.sendMessageToQueue(user);
		return "JSON Message Sent to kafka topic";
	}
	
	@GetMapping("/consume/json")
	public User readJsonMessageFromQueue() {
		User user = consumer.getUserDetails();
		return user;
	}

}
