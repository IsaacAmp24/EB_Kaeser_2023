package com.kaeser.platform.u202112936.inventory.domain.model.aggregates;

import com.kaeser.platform.u202112936.analytics.domain.model.aggregates.MeasurableIndicator;
import com.kaeser.platform.u202112936.inventory.domain.model.valueobjects.EquipmentType;
import com.kaeser.platform.u202112936.inventory.domain.model.valueobjects.MaterialSerialNumberUUID;
import com.kaeser.platform.u202112936.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
public class Equipment extends AuditableAbstractAggregateRoot<Equipment> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Embedded
    @Column(nullable = false)
    private MaterialSerialNumberUUID materialSerialNumberUUID;

    @NotBlank(message = "model is mandatory")
    private String model;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "equipmentType is mandatory")
    private EquipmentType equipmentType;

    // un equipmentType puede tener uno o muchos measurableIndicators
    @OneToMany(mappedBy = "equipmentType", cascade = CascadeType.ALL)
    private Set<MeasurableIndicator> measurableIndicators;

    public Equipment() {
        this.measurableIndicators = new HashSet<>();
        this.materialSerialNumberUUID = new MaterialSerialNumberUUID(UUID.randomUUID());
    }

    public Equipment(String model, EquipmentType equipmentType) {
        this.materialSerialNumberUUID = new MaterialSerialNumberUUID(UUID.randomUUID());
        this.model = model;
        this.equipmentType = equipmentType;
        this.measurableIndicators = new HashSet<>();
    }
}
