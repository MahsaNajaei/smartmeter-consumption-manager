package com.energymeter.consumptionmanagerservice.model.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ConsumptionStatistics {
    private Long energyMeterId;
    private Long userId;
    private Double consumption;
    private Timestamp calculatedAt;
}
