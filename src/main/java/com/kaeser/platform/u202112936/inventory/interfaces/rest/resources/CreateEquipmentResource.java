package com.kaeser.platform.u202112936.inventory.interfaces.rest.resources;

import com.kaeser.platform.u202112936.inventory.domain.model.valueobjects.EquipmentType;

public record CreateEquipmentResource(
        String model,
        EquipmentType equipmentType
) {
}
