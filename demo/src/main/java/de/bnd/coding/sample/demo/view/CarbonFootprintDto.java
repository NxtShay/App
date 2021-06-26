package de.bnd.coding.sample.demo.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"name", "footprint"})
public record CarbonFootprintDto(
        @JsonProperty("name") String name,
        @JsonProperty("footprint") Integer footprint
) { }
