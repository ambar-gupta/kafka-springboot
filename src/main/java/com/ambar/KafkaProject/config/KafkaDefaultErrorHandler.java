package com.ambar.KafkaProject.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.util.backoff.FixedBackOff;

import com.ambar.KafkaProject.json.User;

@Configuration
public class KafkaDefaultErrorHandler {
	
	@Bean
	public DefaultErrorHandler defaultErrorHandler(KafkaTemplate<String, User> kafkaTemplate) {
		
		DeadLetterPublishingRecoverer recoverer = new DeadLetterPublishingRecoverer(kafkaTemplate);
		DefaultErrorHandler defaultErrorHandler = new DefaultErrorHandler(recoverer, new FixedBackOff(1000L, 3L));
		return defaultErrorHandler;
	}
	
	// Define ConcurrentKafkaListenerContainerFactory
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, User> kafkaListenerContainerFactory(
            ConsumerFactory<String, User> consumerFactory, DefaultErrorHandler errorHandler) {
        ConcurrentKafkaListenerContainerFactory<String, User> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        factory.setCommonErrorHandler(errorHandler); // Link DefaultErrorHandler
        return factory;
    }
	
}
