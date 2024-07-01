package com.kaeser.platform.u202112936.inventory.domain.services;

import com.kaeser.platform.u202112936.inventory.domain.model.commands.CreateEquipmentCommand;

public interface EquipmentCommandService {
    Long handle(CreateEquipmentCommand command);

}
