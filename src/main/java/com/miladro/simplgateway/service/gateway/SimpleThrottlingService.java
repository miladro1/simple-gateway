package com.miladro.simplgateway.service.gateway;

import com.miladro.simplgateway.dal.entity.ApiCallRequest;
import com.miladro.simplgateway.dal.repository.APICallsRepository;
import com.miladro.simplgateway.service.gateway.model.RequestData;
import com.miladro.simplgateway.service.gateway.model.TimeUnit;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.util.List;

public class SimpleThrottlingService implements ThrottlingService {
    private final APICallsRepository repository;

    @Value("${throttle.rate-limit}")
    private Integer rateLimit;

    @Value("${throttle.times-number}")
    private Integer timeNumber;

    public SimpleThrottlingService(APICallsRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean check(RequestData request) {
        return getAPICallCountPassed(timeNumber, TimeUnit.HOUR, request) <= rateLimit;
    }

    @Override
    public Integer getAPICallCountPassed(Integer timeNumber, TimeUnit timeUnit, RequestData request) {
        LocalDateTime from = null;
        switch (timeUnit) {
            case MINUTE:
                from = request.getTime().minusMinutes(timeNumber);
                break;
            case HOUR:
                from = request.getTime().minusHours(timeNumber);
                break;
            case DAY:
                from = request.getTime().minusDays(timeNumber);
                break;
            case MONTH:
                from = request.getTime().minusMonths(timeNumber);
                break;
        }
        List<ApiCallRequest> apiCallRequestList = repository
                .findAllByIpIsAndAndTimeBetween(request.getIp(), from, request.getTime());
        return apiCallRequestList.size();
    }
}
