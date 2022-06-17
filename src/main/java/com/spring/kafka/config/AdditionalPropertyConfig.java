package com.spring.kafka.config;

import static org.apache.kafka.streams.StreamsConfig.APPLICATION_ID_CONFIG;
import static org.apache.kafka.streams.StreamsConfig.BOOTSTRAP_SERVERS_CONFIG;
import static org.apache.kafka.streams.StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG;
import static org.apache.kafka.streams.StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG;

import java.util.Properties;

import org.apache.kafka.common.serialization.Serdes;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;

public class AdditionalPropertyConfig {

//	@Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
//	public Properties kStreamsConfig() {
//		kafkaStreamsConfiguration.asProperties().put(APPLICATION_ID_CONFIG, "streams-app");
//		kafkaStreamsConfiguration.asProperties().put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//		kafkaStreamsConfiguration.asProperties().put(DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
//		kafkaStreamsConfiguration.asProperties().put(DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
//		return kafkaStreamsConfiguration.asProperties();
//	}

}
