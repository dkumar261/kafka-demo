package com.spring.kafka.service;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.connect.json.JsonDeserializer;
import org.apache.kafka.connect.json.JsonSerializer;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.spring.kafka.config.KafkaStreamConfig;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
@Configuration
public class UserKafkaListener {

	Deserializer<JsonNode> jsonDeserializer = new JsonDeserializer();
    Serializer<JsonNode> jsonSerializer = new JsonSerializer();

    Serde<JsonNode> jsonSerde = Serdes.serdeFrom(jsonSerializer, jsonDeserializer);
    
    final Serde<Long> longSerde = Serdes.Long();
    private static final Serde<String> STRING_SERDE = Serdes.String();
	
	@Autowired
	KafkaStreamConfig kafkaStreamConfig;

	@Autowired
	public void process(StreamsBuilder streamsBuilder) {
		
		KStream<String, String> messageStream = streamsBuilder.stream("employee");
			
		messageStream.to("male");
		System.out.println("--------------------------------- Kafka Listner----------------------");
	}
}