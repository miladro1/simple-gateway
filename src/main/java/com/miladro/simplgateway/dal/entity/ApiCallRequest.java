package com.miladro.simplgateway.dal.entity;

import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;

public class ApiCallRequest extends Entity {
    @Indexed
    private String ip;
    @Indexed
    private String url;
    private LocalDateTime time;
}
