package com.miladro.simplgateway.service.gateway;

import com.miladro.simplgateway.service.gateway.model.RequestData;

public interface SecurityChecker {
    boolean check(RequestData data);
}
