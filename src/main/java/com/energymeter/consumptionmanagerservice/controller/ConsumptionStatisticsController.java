package com.energymeter.consumptionmanagerservice.controller;

import com.energymeter.consumptionmanagerservice.model.dto.ConsumptionRequest;
import com.energymeter.consumptionmanagerservice.service.ConsumptionManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/statistics")
public class ConsumptionStatisticsController {

    private final ConsumptionManagerService consumptionManager;

    @PostMapping
    public Double retrieveConsumptionOverTime(@RequestBody ConsumptionRequest consumptionRequest, @RequestHeader(required = false) String userId, @RequestHeader(required = false) String role) {
        return consumptionManager.retrieveUserConsumptionOverTime(consumptionRequest, userId, role);
    }

}
