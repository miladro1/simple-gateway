package com.miladro.simplgateway.service.gateway;

import com.miladro.simplgateway.dal.entity.CapthcaTest;

import java.util.List;

public interface JSTestService extends SecurityChecker{
    String generateTest();
    boolean validateTest(String captchaHash);
    List<CapthcaTest> getAllTestsForUser(String ip);
    int getTestSuccessRateForUser(String ip);
}
