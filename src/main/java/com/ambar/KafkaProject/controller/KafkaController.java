package com.ambar.KafkaProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ambar.KafkaProject.consumer.KafkaConsumer;
import com.ambar.KafkaProject.producer.KafkaProducer;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {
	
	private KafkaProducer kafkaProdcuer;
	private KafkaConsumer kafkaConsumer;
	
	public KafkaController(KafkaProducer kafkaProdcuer, KafkaConsumer kafkaConsumer) {
		this.kafkaConsumer = kafkaConsumer;
		this.kafkaProdcuer = kafkaProdcuer;
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

}
