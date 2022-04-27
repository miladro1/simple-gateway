package com.miladro.simplgateway.service.gateway.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RequestData {
    private String ip;
    private String endpoint;
    private LocalDateTime time;
}
