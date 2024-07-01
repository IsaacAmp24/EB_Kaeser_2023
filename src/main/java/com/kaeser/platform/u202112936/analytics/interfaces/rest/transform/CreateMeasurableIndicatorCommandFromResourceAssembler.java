package com.kaeser.platform.u202112936.analytics.interfaces.rest.transform;

import com.kaeser.platform.u202112936.analytics.domain.model.commands.CreateMeasurableIndicatorCommand;
import com.kaeser.platform.u202112936.analytics.interfaces.rest.resources.CreateMeasurableResource;

public class CreateMeasurableIndicatorCommandFromResourceAssembler {
    public static CreateMeasurableIndicatorCommand toCommandFromResource(CreateMeasurableResource resource) {
        return new CreateMeasurableIndicatorCommand(
                resource.symbol(),
                resource.description(),
                resource.thresholdMinimum(),
                resource.thresholdMaximum(),
                resource.equipmentType()

        );

    }
}
