package com.miladro.simplgateway.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class KafkaBrokerProducer implements BrokerProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaBrokerProducer.class);

    public KafkaBrokerProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void produce(String topic, String key, String message) {
        if (Objects.nonNull(key)) {
            kafkaTemplate.send(topic, key, message);
        } else {
            kafkaTemplate.send(topic, message);
        }
        LOGGER.info("kafka message published. topic = {}, message = {}", topic, message);
    }
}