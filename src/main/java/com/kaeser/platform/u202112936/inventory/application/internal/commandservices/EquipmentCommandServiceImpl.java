package com.kaeser.platform.u202112936.inventory.application.internal.commandservices;

import com.kaeser.platform.u202112936.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.u202112936.inventory.domain.model.commands.CreateEquipmentCommand;
import com.kaeser.platform.u202112936.inventory.domain.services.EquipmentCommandService;
import com.kaeser.platform.u202112936.inventory.infrastructure.persistence.jpa.repositories.EquipmentRepository;
import org.springframework.stereotype.Service;

@Service
public class EquipmentCommandServiceImpl implements EquipmentCommandService {
    private final EquipmentRepository equipmentRepository;

    public EquipmentCommandServiceImpl(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }


    @Override
    public Long handle(CreateEquipmentCommand command) {
        // create a new equipment
        Equipment equipment = new Equipment(
                command.model(),
                command.equipmentType()
        );

        // verify if exist equipment with the equal materialSerialNumberUUID
        if (equipmentRepository.existsByMaterialSerialNumberUUID(equipment.getMaterialSerialNumberUUID())) {
            throw new IllegalArgumentException("Equipment already exists with materialSerialNumberUUID " + equipment.getMaterialSerialNumberUUID());
        }

        // save the equipment
        equipmentRepository.save(equipment);

        return equipment.getId();

    }
}
