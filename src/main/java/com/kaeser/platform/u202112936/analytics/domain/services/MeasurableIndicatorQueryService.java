package com.kaeser.platform.u202112936.analytics.domain.services;

import com.kaeser.platform.u202112936.analytics.domain.model.aggregates.MeasurableIndicator;
import com.kaeser.platform.u202112936.analytics.domain.model.queries.GetMeasurableIndicatorByIdQuery;

import java.util.Optional;

public interface MeasurableIndicatorQueryService {
    Optional<MeasurableIndicator> handle(GetMeasurableIndicatorByIdQuery query);
}
