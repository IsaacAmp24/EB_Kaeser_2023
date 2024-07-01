package com.kaeser.platform.u202112936.inventory.domain.model.commands;

import com.kaeser.platform.u202112936.inventory.domain.model.valueobjects.EquipmentType;

public record CreateEquipmentCommand(
        String model,
        EquipmentType equipmentType
) {
}
