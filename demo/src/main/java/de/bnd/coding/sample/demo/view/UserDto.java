package de.bnd.coding.sample.demo.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

// Record is a simple, more simple version of a class
// Its purpose is to simply hold data as it can not have any functions
// However, Getters and Setters are automatically included

// Defines the order of the Json Properties returned
@JsonPropertyOrder({"userName", "userPassword", "firstName", "lastName", "zipCode",
        "peopleInHouse", "heating",  "electricity", "car", "kilometers", "holidayCar",
        "holidayPlane", "holidayTrain", "food", "pvSystem", "recycledGlass",
        "recyclingPlastic", "recyclingPaper", "recyclingMetal", "recyclingFoodwaste",
        "washing", "footPrint", "score"})
public record UserDto (
    // JsonProperty maps a variable to a JSON field. The names do not have to match.
    @JsonProperty("userName") String userName,
    @JsonProperty("userPassword") String userPassword,
    @JsonProperty("firstName") String firstName,
    @JsonProperty("lastName") String lastName,
    @JsonProperty("zipCode") String zipCode,
    @JsonProperty("peopleInHouse") Integer peopleInHouse,
    @JsonProperty("heating") Boolean heating,
    @JsonProperty("electricity") Boolean electricity,
    @JsonProperty("car") String car,
    @JsonProperty("kilometers") Integer kilometers,
    @JsonProperty("holidayCar") Integer holidayCar,
    @JsonProperty("holidayPlane") Integer holidayPlane,
    @JsonProperty("holidayTrain") Integer holidayTrain,
    @JsonProperty("food") String food,
    @JsonProperty("pvSystem") Boolean pvSystem,
    @JsonProperty("recyclingGlass") Boolean recyclingGlass,
    @JsonProperty("recyclingPlastic") Boolean recyclingPlastic,
    @JsonProperty("recyclingPaper") Boolean recyclingPaper,
    @JsonProperty("recyclingMetal") Boolean recyclingMetal,
    @JsonProperty("recyclingFoodwaste") Boolean recyclingFoodwaste,
    @JsonProperty("footprint") String washing,
    @JsonProperty("footPrint") Integer footPrint,
    @JsonProperty("score") Integer score
) { }