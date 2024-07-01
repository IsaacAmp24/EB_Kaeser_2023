package com.kaeser.platform.u202112936.inventory.interfaces.rest.transform;

import com.kaeser.platform.u202112936.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.u202112936.inventory.interfaces.rest.resources.CreateEquipmentResource;
import com.kaeser.platform.u202112936.inventory.interfaces.rest.resources.EquipmentResource;

public class EquipmentResourceFromEntityAssembler {
    public static EquipmentResource toResourceFromEntity(Equipment equipment) {
        return new EquipmentResource(
                equipment.getId(),
                equipment.getModel(),
                equipment.getMaterialSerialNumberUUID().materialSerialNumberUUID().toString(),
                equipment.getEquipmentType().name()
                );
    }
}
