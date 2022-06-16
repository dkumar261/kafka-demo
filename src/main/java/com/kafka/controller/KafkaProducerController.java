package com.kafka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafka.model.TransactionMessage;
import com.kafka.service.KafKaProducerService;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaProducerController {

	private final KafKaProducerService producerService;

	@Autowired
	public KafkaProducerController(KafKaProducerService producerService) {
		this.producerService = producerService;
	}

//	@PostMapping(value = "/publish")
//	public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
//		this.producerService.sendMessage(message);
//	}

	@PostMapping(value = "/publish")
	public String sendJsonToKafkaTopic(@RequestBody TransactionMessage message) {
		producerService.sendCustomMessage(message);

		return "Done !!";

	}
}