package com.ambar.KafkaProject.config;

import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component("myErrorHandler")
public class KafkaErrorHandler implements KafkaListenerErrorHandler{

	@Override
	public Object handleError(Message<?> message, ListenerExecutionFailedException exception) {
		// TODO Auto-generated method stub
		System.out.println("Error in Listner : " + exception.getMessage());
		return null;  
	}

}
