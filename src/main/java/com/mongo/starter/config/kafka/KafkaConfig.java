package com.mongo.starter.config.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

//	@Bean
//	KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory() {
//		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
//		factory.setMessageConverter(new StringJsonMessageConverter());
//		factory.setConsumerFactory(consumerFactory());
//		return factory;
//	}

	@Bean("batchKafkaListenerContainerFactory")
	ConcurrentKafkaListenerContainerFactory<Object, Object> batchKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setBatchListener(true);
		factory.setConsumerFactory(consumerFactory());
		factory.setConcurrency(2);
		return factory;
	}

	@Bean
	public ConsumerFactory<Object, Object> consumerFactory() {
		return new DefaultKafkaConsumerFactory<>(consumerConfiguration());
	}

	@Bean
	public Map<String, Object> consumerConfiguration() {
		Map<String, Object> properties = new HashMap<>();
		//TODO - config로 빼기
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092");
		properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		properties.put(ConsumerConfig.GROUP_ID_CONFIG, "cdc_group");
//		properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
		properties.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 1000);
		properties.put(ConsumerConfig.FETCH_MAX_BYTES_CONFIG, 1024 * 1024);
		properties.put(ConsumerConfig.FETCH_MAX_WAIT_MS_CONFIG, 2000);

		return properties;
	}
}
