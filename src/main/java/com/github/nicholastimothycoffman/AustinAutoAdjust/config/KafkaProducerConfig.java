package com.github.nicholastimothycoffman.AustinAutoAdjust.config;

import com.github.nicholastimothycoffman.AustinAutoAdjust.premiumadjustment.model.PremiumAdjustment;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

/**
 * Configuration class for setting up a Kafka producer in the AustinAutoAdjust application.
 * This class defines beans for creating a Kafka producer factory and a Kafka template
 * for sending messages related to {@link PremiumAdjustment}.
 */
@Configuration
public class KafkaProducerConfig {

	/**
	 * Creates a Kafka {@link ProducerFactory} bean responsible for producing messages.
	 * The producer is configured to connect to a Kafka broker at "localhost:9092" and
	 * serialize messages using JSON.
	 *
	 * @return A {@link ProducerFactory} instance for Kafka message production.
	 */
	@Bean
    	public ProducerFactory<String, PremiumAdjustment> producerFactory() {
        	Map<String, Object> configProps = new HashMap<>();
        	configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); // Kafka broker address
        	configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class); // Serializes message keys as Strings
        	configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class); // Serializes message values as JSON
        	return new DefaultKafkaProducerFactory<>(configProps);
    	}

	/**
	 * Creates a KafkaTemplate bean used to send messages to Kafka topics.
	 * This template wraps the {@link ProducerFactory} to facilitate message production.
	 *
	 * @return A {@link KafkaTemplate} instance for publishing messages to Kafka.
	 */
    	@Bean
    	public KafkaTemplate<String, PremiumAdjustment> kafkaTemplate() {
        	return new KafkaTemplate<>(producerFactory());
    	}
}

