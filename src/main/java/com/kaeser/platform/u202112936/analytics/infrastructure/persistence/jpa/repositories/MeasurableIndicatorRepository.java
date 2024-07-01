package com.kaeser.platform.u202112936.analytics.infrastructure.persistence.jpa.repositories;

import com.kaeser.platform.u202112936.analytics.domain.model.aggregates.MeasurableIndicator;
import com.kaeser.platform.u202112936.analytics.domain.model.valueobjects.EquipmentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MeasurableIndicatorRepository extends JpaRepository<MeasurableIndicator, Long>
{
    Optional<MeasurableIndicator> findMeasurableIndicatorBySymbolAndEquipmentType(String symbol, EquipmentType equipmentType);

}
