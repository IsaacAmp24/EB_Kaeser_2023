package com.kaeser.platform.u202112936.analytics.domain.model.aggregates;

import com.kaeser.platform.u202112936.analytics.domain.model.valueobjects.EquipmentType;
import com.kaeser.platform.u202112936.inventory.domain.model.aggregates.Equipment;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
@Entity
public class MeasurableIndicator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "symbol is mandatory")
    private String symbol;

    private String description;

    @NotNull(message = "thresholdMinimum is mandatory")
    private Double thresholdMinimum;

    @NotNull(message = "thresholdMaximum is mandatory")
    private Double thresholdMaximum;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "equipmentType is mandatory")
    private EquipmentType equipmentType;

    // pero un measurableIndicator solo puede relacionarse con un equipmentType
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipment_id", referencedColumnName = "id")
    private Equipment equipment;

    public MeasurableIndicator() {
    }

    public MeasurableIndicator(String symbol, String description, Double thresholdMinimum, Double thresholdMaximum, EquipmentType equipmentType, Equipment equipment) {
        this.symbol = symbol;
        this.description = description;
        this.thresholdMinimum = thresholdMinimum;
        this.thresholdMaximum = thresholdMaximum;
        this.equipmentType = equipmentType;
        this.equipment = equipment;
    }
}
