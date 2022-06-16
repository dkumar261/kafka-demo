package com.kafka;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
public class KafkaTest {

	@Autowired
    public KafkaTemplate<String, String> template;


	@Test
	public void givenEmbeddedKafkaBroker_whenSendingtoSimpleProducer_thenMessageReceived() {
	//	producer.sendMessage("Sending with own simple KafkaProducer");
		ProducerRecord<String, String> pr = new ProducerRecord<>("test", "Hello world !! ");
		template.send(pr);
//		template.send("test","Sending with own simple KafkaProducer-- from template");
	}
}
