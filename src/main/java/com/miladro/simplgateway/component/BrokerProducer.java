package com.miladro.simplgateway.component;

public interface BrokerProducer {
    void produce(String topic, String key, String message);
}
