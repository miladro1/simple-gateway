package com.miladro.simplgateway.service.gateway;

import com.miladro.simplgateway.service.gateway.model.TimeUnit;
import com.miladro.simplgateway.service.gateway.model.RequestData;

public interface ThrottlingService extends SecurityChecker {
    Integer getAPICallCountPassed(Integer timeNumber, TimeUnit timeUnit, RequestData request);
}
