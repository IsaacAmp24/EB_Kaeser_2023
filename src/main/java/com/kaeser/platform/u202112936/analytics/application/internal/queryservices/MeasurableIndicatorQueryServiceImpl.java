package com.kaeser.platform.u202112936.analytics.application.internal.queryservices;

import com.kaeser.platform.u202112936.analytics.domain.model.aggregates.MeasurableIndicator;
import com.kaeser.platform.u202112936.analytics.domain.model.queries.GetMeasurableIndicatorByIdQuery;
import com.kaeser.platform.u202112936.analytics.domain.services.MeasurableIndicatorQueryService;
import com.kaeser.platform.u202112936.analytics.infrastructure.persistence.jpa.repositories.MeasurableIndicatorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MeasurableIndicatorQueryServiceImpl implements MeasurableIndicatorQueryService {

    private final MeasurableIndicatorRepository measurableIndicatorRepository;

    public MeasurableIndicatorQueryServiceImpl(MeasurableIndicatorRepository measurableIndicatorRepository) {
        this.measurableIndicatorRepository = measurableIndicatorRepository;
    }

    @Override
    public Optional<MeasurableIndicator> handle(GetMeasurableIndicatorByIdQuery query) {
        return measurableIndicatorRepository.findById(query.id());
    }
}
