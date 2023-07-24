package com.energymeter.consumptionmanagerservice.service;

import com.energymeter.consumptionmanagerservice.exception.ApplicationRuntimeException;
import com.energymeter.consumptionmanagerservice.model.dto.ConsumptionRequest;
import com.energymeter.consumptionmanagerservice.model.entity.EnergyMeterData;
import com.energymeter.consumptionmanagerservice.repository.EnergyMeterDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
public class ConsumptionManager implements ConsumptionManagerService {

    private final EnergyMeterDataRepository energyMeterDataRepository;

    @Override
    public Double retrieveUserConsumptionOverTime(ConsumptionRequest consumptionRequest, String headerUserId, String headerRole) {
        validateUserId(consumptionRequest.getUserId(), headerUserId, headerRole);
        return energyMeterDataRepository.getTotalConsumptionBetweenDatesByUserId(consumptionRequest.getUserId(), Timestamp.valueOf(consumptionRequest.getFromDate()), Timestamp.valueOf(consumptionRequest.getToDate()));
    }

    private void validateUserId(Long userId, String headerUserId, String headerRole) {
        if (!ObjectUtils.isEmpty(headerRole)
                && !ObjectUtils.isEmpty(headerUserId)
                && !headerRole.equalsIgnoreCase("ADMIN")
                && !headerUserId.equals(userId))
            throw new ApplicationRuntimeException("Authenticated User is Not Allowed to Get Other Users Info!");
        if (ObjectUtils.isEmpty(userId))
            throw new ApplicationRuntimeException("User Not Defined!");
    }

    @Override
    public void saveEnergyMeterData(EnergyMeterData energyMeterData) {
        energyMeterDataRepository.save(energyMeterData);
    }

}
