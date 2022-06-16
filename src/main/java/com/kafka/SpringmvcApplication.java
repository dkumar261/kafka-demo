package com.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

@EnableKafka
@Configuration
@SpringBootApplication
public class SpringmvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmvcApplication.class, args);
	}
	

	@Bean
	public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> stringFilterKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
//		factory.setConsumerFactory(consumerFactoryWithFilter());
		factory.setAckDiscarded(true);
		factory.setRecordFilterStrategy(consumeMessage -> 
			(consumeMessage.key().contains(null)));
		return factory;
	}
	
}

