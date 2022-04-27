package com.miladro.simplgateway.service.gateway;

import com.miladro.simplgateway.dal.entity.CapthcaTest;
import com.miladro.simplgateway.service.gateway.model.RequestData;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class SimpleCaptchaService implements CaptchaService {
    @Value("${captcha.min-success-rate}")
    private Integer captchaMinSuccessRate;

    @Override
    public String generateCaptcha() {
        return null;
    }

    @Override
    public boolean validateCaptcha(String captchaHash) {
        return false;
    }

    @Override
    public List<CapthcaTest> getAllCaptchaForUser(String ip) {
        return null;
    }

    @Override
    public int getCaptchaSuccessRateForUser(String ip) {
        return 90;
    }

    @Override
    public boolean check(RequestData data) {
        return getCaptchaSuccessRateForUser(data.getIp()) >= captchaMinSuccessRate;
    }
}
