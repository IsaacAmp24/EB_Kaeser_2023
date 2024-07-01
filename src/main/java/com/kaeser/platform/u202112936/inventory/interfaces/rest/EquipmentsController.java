package com.kaeser.platform.u202112936.inventory.interfaces.rest;

import com.kaeser.platform.u202112936.inventory.domain.model.queries.GetEquipmentByIdQuery;
import com.kaeser.platform.u202112936.inventory.domain.services.EquipmentCommandService;
import com.kaeser.platform.u202112936.inventory.domain.services.EquipmentQueryService;
import com.kaeser.platform.u202112936.inventory.interfaces.rest.resources.CreateEquipmentResource;
import com.kaeser.platform.u202112936.inventory.interfaces.rest.resources.EquipmentResource;
import com.kaeser.platform.u202112936.inventory.interfaces.rest.transform.CreateEquipmentCommandFromResourceAssembler;
import com.kaeser.platform.u202112936.inventory.interfaces.rest.transform.EquipmentResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/equipments", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Equipments", description = "Equipment Management Endpoints")
public class EquipmentsController {

    private final  EquipmentCommandService equipmentCommandService;
    private final EquipmentQueryService equipmentQueryService;

    public EquipmentsController(EquipmentCommandService equipmentCommandService, EquipmentQueryService equipmentQueryService) {
        this.equipmentCommandService = equipmentCommandService;
        this.equipmentQueryService = equipmentQueryService;
    }

    // documentation for the createEquipment method in Swagger
    @Operation(summary = "Create a new equipment", description = "Creates a new equipment with the specified details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Equipment created successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EquipmentResource.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid input or validation error",
                    content = @Content),
            @ApiResponse(responseCode = "409", description = "Equipment already exists",
                    content = @Content)
    })

    @PostMapping
    public ResponseEntity<EquipmentResource> createEquipment(@RequestBody CreateEquipmentResource resource) {
        var createEquipmentCommand = CreateEquipmentCommandFromResourceAssembler.toCommandFromResource(resource);
        var equipmentId = equipmentCommandService.handle(createEquipmentCommand);

        if (equipmentId == 0L) {
            return ResponseEntity.badRequest().build();
        }

        var getEquipmentByIdQuery = new GetEquipmentByIdQuery(equipmentId);
        var equipment = equipmentQueryService.handle(getEquipmentByIdQuery);

        if (equipment.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        var equipmentResource = EquipmentResourceFromEntityAssembler.toResourceFromEntity(equipment.get());
        return new ResponseEntity<>(equipmentResource, HttpStatus.CREATED);
    }
}
