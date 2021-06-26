package de.bnd.coding.sample.demo.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"recommondation", "basedOn", "zipCode"})
public record RecDto(
        @JsonProperty("recommondation") String recommondation,
        @JsonProperty("basedOn") String basedOn,
        @JsonProperty("zipCode") String zipCode
) {
}
