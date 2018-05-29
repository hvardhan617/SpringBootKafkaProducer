package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaSender.class);
	private KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	public KafkaSender(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	@Value("${kafka.topic}")
	private String topic;

	public void send(String data) {
		LOGGER.info("sending payload='{}' to topic='{}'", data, topic);
		kafkaTemplate.send(topic, data);
	}

}
