package de.bnd.coding.sample.demo.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"challenge", "category", "score"})
public record ChallengeDto(
        @JsonProperty("challenge") String challenge,
        @JsonProperty("category") String category,
        @JsonProperty("score") Integer score
) { }
