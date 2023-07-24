package com.energymeter.consumptionmanagerservice.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@Entity
public class EnergyMeterData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long energyMeterId;
    @Column(nullable = false)
    private Long userId;
    @Column(nullable = false)
    private Double consumption;
    @Column(nullable = false)
    private Timestamp recordedAt;
}
