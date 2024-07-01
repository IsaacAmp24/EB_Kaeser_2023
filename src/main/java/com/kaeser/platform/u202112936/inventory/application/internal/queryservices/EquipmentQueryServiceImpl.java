package com.kaeser.platform.u202112936.inventory.application.internal.queryservices;

import com.kaeser.platform.u202112936.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.u202112936.inventory.domain.model.queries.GetEquipmentByIdQuery;
import com.kaeser.platform.u202112936.inventory.domain.services.EquipmentQueryService;
import com.kaeser.platform.u202112936.inventory.infrastructure.persistence.jpa.repositories.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EquipmentQueryServiceImpl implements EquipmentQueryService {
    private final EquipmentRepository equipmentRepository;

    public EquipmentQueryServiceImpl(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public Optional<Equipment> handle(GetEquipmentByIdQuery query) {
        return equipmentRepository.findById(query.id());
    }
}
