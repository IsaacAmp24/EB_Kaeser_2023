package com.kaeser.platform.u202112936.inventory.infrastructure.persistence.jpa.repositories;

import com.kaeser.platform.u202112936.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.u202112936.inventory.domain.model.valueobjects.MaterialSerialNumberUUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long>{
    // no se permite que se registre 2 equipmentos con el mismo serial number
    Optional<Equipment> findByMaterialSerialNumberUUID(MaterialSerialNumberUUID materialSerialNumberUUID);
    boolean existsByMaterialSerialNumberUUID(MaterialSerialNumberUUID materialSerialNumberUUID);

}
