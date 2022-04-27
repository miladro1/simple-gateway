package com.miladro.simplgateway.service.gateway;

import com.miladro.simplgateway.dal.entity.CapthcaTest;
import com.miladro.simplgateway.service.gateway.model.RequestData;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class SimpleJSTestService implements JSTestService{
    @Value("${js-test.min-success-rate}")
    private Integer minSuccessRate;

    @Override
    public String generateTest() {
        return null;
    }

    @Override
    public boolean validateTest(String captchaHash) {
        return false;
    }

    @Override
    public List<CapthcaTest> getAllTestsForUser(String ip) {
        return null;
    }

    @Override
    public int getTestSuccessRateForUser(String ip) {
        return 0;
    }

    @Override
    public boolean check(RequestData data) {
        return getTestSuccessRateForUser(data.getIp()) >= minSuccessRate;
    }
}
