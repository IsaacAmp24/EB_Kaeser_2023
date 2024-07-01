package com.kaeser.platform.u202112936.analytics.interfaces.rest.resources;

import com.kaeser.platform.u202112936.analytics.domain.model.valueobjects.EquipmentType;

public record MeasurableResource(
        Long id,
        String symbol,
        String description,
        Double thresholdMinimum,
        Double thresholdMaximum,
        EquipmentType equipmentType
) {
}
