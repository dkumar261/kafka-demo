package com.kafka.service;

import org.apache.kafka.streams.kstream.KStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.model.TransactionMessage;
import com.kafka.util.AppConstants;

@Service
public class KafKaConsumerService {
	private final Logger logger = LoggerFactory.getLogger(KafKaConsumerService.class);

	@KafkaListener(topics = AppConstants.TOPIC_NAME, groupId = AppConstants.GROUP_ID)
	
	public void consume(KStream<String,TransactionMessage> message) {
		logger.info(String.format("Message recieved -> %s", message));
	}
}