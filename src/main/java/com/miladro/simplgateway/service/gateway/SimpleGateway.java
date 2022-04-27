package com.miladro.simplgateway.service.gateway;

import com.miladro.simplgateway.component.KafkaBrokerProducer;
import com.miladro.simplgateway.service.gateway.model.RequestData;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class SimpleGateway implements Gateway {
    private final List<SecurityChecker> securityCheckersList;
    private final KafkaBrokerProducer brokerProducer;

    @Value("${broker.kafka.request-data-topic}")
    private String requestDataTopic;

    public SimpleGateway(List<SecurityChecker> securityCheckersList, KafkaBrokerProducer brokerProducer) {
        this.securityCheckersList = securityCheckersList;
        this.brokerProducer = brokerProducer;
    }

    @Override
    //todo: this could return a Redirection(for example) object that client of the API can call redirect() method of it.
    public boolean isAllowed(RequestData request) {
        recordRequest(request);
        securityCheckersList.forEach(securityChecker -> securityChecker.check(request));
        redirect(request);
        return true;
    }

    @Override
    public void recordRequest(RequestData request) {
        brokerProducer.produce(requestDataTopic, request.getIp(), request.toString());
    }

    @Override
    public void redirect(RequestData request) {
        //todo: marshal request data to json
    }
}
