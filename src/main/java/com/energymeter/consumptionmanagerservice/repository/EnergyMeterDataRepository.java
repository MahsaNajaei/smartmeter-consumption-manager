package com.energymeter.consumptionmanagerservice.repository;

import com.energymeter.consumptionmanagerservice.model.entity.EnergyMeterData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface EnergyMeterDataRepository extends JpaRepository<EnergyMeterData, Long> {

    @Query("select max(consumption) - min(consumption) FROM EnergyMeterData where userId = ?1 and recordedAt between ?2 and ?3")
    Double getTotalConsumptionBetweenDatesByUserId(long userId, Timestamp startDate, Timestamp endDate);

}
