package com.kafka.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafka.model.TransactionMessage;
import com.kafka.util.AppConstants;

@Service
public class KafKaProducerService {
	private static final Logger logger = LoggerFactory.getLogger(KafKaProducerService.class);

	@Autowired
	private KafkaTemplate<String, TransactionMessage> kafkaTemplate;
	
	@Autowired
	private  KafkaTemplate<String, TransactionMessage> transactionKafkaTemplate;

//	public void sendMessage(String message) {
//		logger.info(String.format("Message sent -> %s", message));
//		this.kafkaTemplate.send(AppConstants.TOPIC_NAME, message);
//	}
	
	public void sendCustomMessage(TransactionMessage transaction) {
		kafkaTemplate.send(AppConstants.TOPIC_NAME,transaction);
	}
}