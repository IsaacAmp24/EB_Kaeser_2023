package com.kaeser.platform.u202112936.inventory.domain.services;

import com.kaeser.platform.u202112936.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.u202112936.inventory.domain.model.queries.GetEquipmentByIdQuery;

import java.util.Optional;

public interface EquipmentQueryService {
    Optional<Equipment> handle(GetEquipmentByIdQuery query);
}
