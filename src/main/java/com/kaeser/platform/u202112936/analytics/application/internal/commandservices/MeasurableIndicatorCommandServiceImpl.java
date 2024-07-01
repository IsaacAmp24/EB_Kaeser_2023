package com.kaeser.platform.u202112936.analytics.application.internal.commandservices;

import com.kaeser.platform.u202112936.analytics.domain.model.aggregates.MeasurableIndicator;
import com.kaeser.platform.u202112936.analytics.domain.model.commands.CreateMeasurableIndicatorCommand;
import com.kaeser.platform.u202112936.analytics.domain.services.MeasurableIndicatorCommandService;
import com.kaeser.platform.u202112936.analytics.infrastructure.persistence.jpa.repositories.MeasurableIndicatorRepository;
import org.springframework.stereotype.Service;

@Service
public class MeasurableIndicatorCommandServiceImpl implements MeasurableIndicatorCommandService {
    private final MeasurableIndicatorRepository measurableIndicatorRepository;

    public MeasurableIndicatorCommandServiceImpl(MeasurableIndicatorRepository measurableIndicatorRepository) {
        this.measurableIndicatorRepository = measurableIndicatorRepository;
    }

    @Override
    public Long handle(CreateMeasurableIndicatorCommand command) {

        // validate if MeasurableIndicator already exists with equal symbol and equipmentType
        if (measurableIndicatorRepository.findMeasurableIndicatorBySymbolAndEquipmentType(command.symbol(), command.equipmentType()).isPresent()) {
            throw new IllegalArgumentException("MeasurableIndicator already exists with symbol " + command.symbol() + " and equipmentType " + command.equipmentType());
        }

        // validate if thresholdMaximum is >= thresholdMinimum
        if (command.thresholdMaximum() < command.thresholdMinimum()) {
            throw new IllegalArgumentException("thresholdMaximum must be greater than or equal to thresholdMinimum");
        }

        MeasurableIndicator measurableIndicator = new MeasurableIndicator(
                command.symbol(),
                command.description(),
                command.thresholdMinimum(),
                command.thresholdMaximum(),
                command.equipmentType(),
                null
        );

        measurableIndicatorRepository.save(measurableIndicator);

        return measurableIndicator.getId();

    }
}
