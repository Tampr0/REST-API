package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true) // annotation tells to ignore all json fields not included
                                            // in fields of this class.
public class TrelloListDto {

    @JsonProperty("id")     // annotation tells to map from exact field eg. "id", you can change the name of
                            // the field of the class and it's still gonna map from "id" field.
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("closed")
    private boolean isClosed;

}
