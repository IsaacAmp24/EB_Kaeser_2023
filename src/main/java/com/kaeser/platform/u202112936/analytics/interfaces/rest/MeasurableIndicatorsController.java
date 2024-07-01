package com.kaeser.platform.u202112936.analytics.interfaces.rest;

import com.kaeser.platform.u202112936.analytics.domain.model.queries.GetMeasurableIndicatorByIdQuery;
import com.kaeser.platform.u202112936.analytics.domain.services.MeasurableIndicatorCommandService;
import com.kaeser.platform.u202112936.analytics.domain.services.MeasurableIndicatorQueryService;
import com.kaeser.platform.u202112936.analytics.interfaces.rest.resources.CreateMeasurableResource;
import com.kaeser.platform.u202112936.analytics.interfaces.rest.resources.MeasurableResource;
import com.kaeser.platform.u202112936.analytics.interfaces.rest.transform.CreateMeasurableIndicatorCommandFromResourceAssembler;
import com.kaeser.platform.u202112936.analytics.interfaces.rest.transform.MeasurableResourceFromEntityAssembler;
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
@RequestMapping(value = "/api/v1/measurable-indicators", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Measurable Indicators Endpoint", description = "Endpoint for managing measurable indicators")
public class MeasurableIndicatorsController {

    private final MeasurableIndicatorQueryService measurableIndicatorQueryService;
    private final MeasurableIndicatorCommandService measurableIndicatorCommandService;


    public MeasurableIndicatorsController(MeasurableIndicatorQueryService measurableIndicatorQueryService, MeasurableIndicatorCommandService measurableIndicatorCommandService) {
        this.measurableIndicatorQueryService = measurableIndicatorQueryService;
        this.measurableIndicatorCommandService = measurableIndicatorCommandService;
    }


    // documentation for the createMeasurableIndicator method in Swagger
    @Operation(summary = "Create a new measurable indicator", description = "Creates a new measurable indicator with the specified details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Measurable Indicator created successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MeasurableResource.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid input or validation error",
                    content = @Content),
            @ApiResponse(responseCode = "409", description = "Measurable Indicator already exists",
                    content = @Content)
    })


    @PostMapping
    public ResponseEntity<MeasurableResource> createMeasurableIndicator(@RequestBody CreateMeasurableResource resource) {
        var createMeasurableIndicatorCommand = CreateMeasurableIndicatorCommandFromResourceAssembler.toCommandFromResource(resource);

        var measurableIndicatorId = measurableIndicatorCommandService.handle(createMeasurableIndicatorCommand);

        if (measurableIndicatorId == 0L) {
            return ResponseEntity.badRequest().build();
        }

        var getMeasurableIndicatorByIdQuery = new GetMeasurableIndicatorByIdQuery(measurableIndicatorId);
        var measurableIndicator = measurableIndicatorQueryService.handle(getMeasurableIndicatorByIdQuery);

        if (measurableIndicator.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        var measurableResource = MeasurableResourceFromEntityAssembler.toResourceFromEntity(measurableIndicator.get());
        return new ResponseEntity<>(measurableResource, HttpStatus.CREATED);
    }
}
