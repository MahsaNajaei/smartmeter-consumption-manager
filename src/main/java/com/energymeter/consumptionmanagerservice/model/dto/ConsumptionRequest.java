package com.energymeter.consumptionmanagerservice.model.dto;

import lombok.Data;

@Data
public class ConsumptionRequest {
    private Long userId;
    private String fromDate;
    private String toDate;
}
