package com.miladro.simplgateway.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ExampleEventListener implements Listener<String> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExampleEventListener.class);

    private static Long numbersSum = 0L;

//    @Value("${broker.topics.rand-numbers}")
//    private String topic;

//    private final RandNumberRepository randNumberRepository;
//
//    public ExampleEventListener(RandNumberRepository randNumberRepository) {
//        this.randNumberRepository = randNumberRepository;
//    }

//    @Override
//    @KafkaListener(
//            topics = "${broker.topics.rand-numbers}",
//            groupId = "${spring.kafka.consumer.group-id}"
//    )
    public void listen(String message) {
//        randNumberRepository.incrRandNumberSum(Long.getLong(message));
//        LOGGER.info("kafka message consumed. topic = " + topic + ", message = {}", message);
    }
}
