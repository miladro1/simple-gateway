package com.miladro.simplgateway.service.gateway;

import com.miladro.simplgateway.service.gateway.model.RequestData;

public interface Gateway {
    boolean isAllowed(RequestData requestData);
    void recordRequest(RequestData requestData);
    void redirect(RequestData requestData);
}
