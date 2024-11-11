package com.kafkaconsumer.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.kafkaconsumer.model.api.Client;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumer {

	@KafkaListener(topics = "${kafka.topic.name}", groupId = "${Spring.kafka.consumer.group-id}")
	public void receiveMessage(String message) {
		log.info("Received message:" + message);
		Gson gson = new Gson();
		Client client;
		try {
			client = gson.fromJson(message, Client.class);
			log.info(client.toString());
		} catch (IllegalStateException | JsonSyntaxException exception) {
			log.error(exception.getMessage(), exception);

		}
	}
	
}
