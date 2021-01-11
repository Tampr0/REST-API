package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatedTrelloCard {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("shortUrl")
    private String shortUrl;

    private int badgesVotes;
    private int badgesAttachmentsByTypeTrelloBoard;
    private int badgesAttachmentsByTypeTrelloCard;

    // solution from https://www.baeldung.com/jackson-nested-values

    @SuppressWarnings("unchecked")
    @JsonProperty("badges")
    public void unpackNested(Map<String,Object> badges) {
        this.badgesVotes = (Integer)badges.get("votes");
        Map<String, Object> attachmentsByType = (Map<String, Object>) badges.get("attachmentsByType");
        Map<String, Integer> trello = (Map<String, Integer>) attachmentsByType.get("trello");
        this.badgesAttachmentsByTypeTrelloBoard = trello.get("board");
        this.badgesAttachmentsByTypeTrelloCard = trello.get("card");
    }
}
