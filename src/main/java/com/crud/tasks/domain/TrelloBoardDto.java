package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrelloBoardDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("lists")
    private List<TrelloListDto> lists;

    public TrelloBoardDto(String id, String name, List<TrelloListDto> lists) {
        this.id = id;
        this.name = name;
        this.lists = lists;
    }

    public TrelloBoardDto() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<TrelloListDto> getLists() {
        return lists;
    }
}
