package com.miladro.simplgateway.dal.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@Document
public class JSTest extends Entity {
    private String jsCode;
}
