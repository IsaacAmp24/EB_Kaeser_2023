package com.kaeser.platform.u202112936.analytics.domain.services;

import com.kaeser.platform.u202112936.analytics.domain.model.commands.CreateMeasurableIndicatorCommand;

public interface MeasurableIndicatorCommandService {
    Long handle(CreateMeasurableIndicatorCommand command);
}
