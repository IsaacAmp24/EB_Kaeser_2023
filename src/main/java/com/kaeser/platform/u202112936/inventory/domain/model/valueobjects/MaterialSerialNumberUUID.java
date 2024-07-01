package com.kaeser.platform.u202112936.inventory.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;


@Embeddable
public record MaterialSerialNumberUUID(UUID materialSerialNumberUUID) {

    public MaterialSerialNumberUUID {
        if (materialSerialNumberUUID == null) {
            materialSerialNumberUUID = UUID.randomUUID();
        }
    }

    public MaterialSerialNumberUUID() {
     this(UUID.randomUUID());
    }

}
