package com.miladro.simplgateway.events;

import com.miladro.simplgateway.component.BrokerProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ExampleEventOccured implements Event {
    private final BrokerProducer brokerProducer;

    @Value("${broker.topics.rand-numbers}")
    private String topic;

    // event-key is used in order to maintain total order.
    private static final String eventKey = "0_100_RAND_NUMBER";


    public ExampleEventOccured(BrokerProducer brokerProducer) {
        this.brokerProducer = brokerProducer;
    }

    @Override
    public void fire() {
//        brokerProducer.produce(topic, eventKey, String.valueOf(randNumber));
    }
}
