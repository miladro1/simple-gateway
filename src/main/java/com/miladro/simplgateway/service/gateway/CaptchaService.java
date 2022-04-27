package com.miladro.simplgateway.service.gateway;

import com.miladro.simplgateway.dal.entity.CapthcaTest;

import java.util.List;

public interface CaptchaService extends SecurityChecker {
    String generateCaptcha();
    boolean validateCaptcha(String captchaHash);
    List<CapthcaTest> getAllCaptchaForUser(String ip);
    int getCaptchaSuccessRateForUser(String ip);
}
