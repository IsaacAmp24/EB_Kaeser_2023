package com.kaeser.platform.u202112936.inventory.interfaces.rest.resources;

public record EquipmentResource(
        Long id,
        String model,
        String materialSerialNumber,
        String equipmentType
) {
}
