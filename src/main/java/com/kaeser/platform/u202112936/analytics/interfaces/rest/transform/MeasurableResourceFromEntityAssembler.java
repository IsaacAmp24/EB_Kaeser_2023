package com.kaeser.platform.u202112936.analytics.interfaces.rest.transform;

import com.kaeser.platform.u202112936.analytics.domain.model.aggregates.MeasurableIndicator;
import com.kaeser.platform.u202112936.analytics.interfaces.rest.resources.MeasurableResource;

public class MeasurableResourceFromEntityAssembler {
    public static MeasurableResource toResourceFromEntity(MeasurableIndicator measurableIndicator) {
        return new MeasurableResource(
                measurableIndicator.getId(),
                measurableIndicator.getSymbol(),
                measurableIndicator.getDescription(),
                measurableIndicator.getThresholdMinimum(),
                measurableIndicator.getThresholdMaximum(),
                measurableIndicator.getEquipmentType()
        );
    }
}
