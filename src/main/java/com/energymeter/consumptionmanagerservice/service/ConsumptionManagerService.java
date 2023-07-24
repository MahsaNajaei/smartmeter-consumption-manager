package com.energymeter.consumptionmanagerservice.service;

import com.energymeter.consumptionmanagerservice.model.dto.ConsumptionRequest;
import com.energymeter.consumptionmanagerservice.model.entity.EnergyMeterData;

public interface ConsumptionManagerService {
    Double retrieveUserConsumptionOverTime(ConsumptionRequest consumptionRequest, String headerUserId, String headerRole);
    void saveEnergyMeterData(EnergyMeterData energyMeterData);
}
