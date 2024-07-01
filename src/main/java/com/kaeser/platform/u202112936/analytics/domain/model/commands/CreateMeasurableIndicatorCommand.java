package com.kaeser.platform.u202112936.analytics.domain.model.commands;

import com.kaeser.platform.u202112936.analytics.domain.model.valueobjects.EquipmentType;

public record CreateMeasurableIndicatorCommand(
    String symbol,
    String description,
    Double thresholdMinimum,
    Double thresholdMaximum,
    EquipmentType equipmentType
) {
}
