package com.ambar.KafkaProject.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.ambar.KafkaProject.json.User;

@Component
public class DeadLetterTopicConsumer {

    @KafkaListener(topics = "json_topic.DLT", groupId = "dlt_group", containerFactory = "kafkaListenerContainerFactory")
    public void handleDead(User user) {
        System.out.println("--- Received from DLT: " + user);
    }
}
