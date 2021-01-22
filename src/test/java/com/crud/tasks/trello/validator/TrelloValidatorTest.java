package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.domain.TrelloList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloValidatorTest {

    @Autowired
    private TrelloValidator trelloValidator;

    @Test
    public void validateTrelloBoardsWithKeyWordTest() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("1", "list_test", false));

        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1", "test", trelloLists));

        //when
        List<TrelloBoard> result = trelloValidator.validateTrelloBoards(trelloBoards);

        //then
        assertNotNull(result);
        assertEquals(0, result.size());

    }
    @Test
    public void validateTrelloBoardsWithoutKeyWordTest() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("1", "list_test", false));

        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1", "board_test", trelloLists));

        //When
        List<TrelloBoard> result = trelloValidator.validateTrelloBoards(trelloBoards);

        //then
        assertEquals(1, result.size());
        result.forEach(trelloBoard -> {
            assertEquals("1", trelloBoard.getId());
            assertEquals("board_test", trelloBoard.getName());
            trelloBoard.getLists().forEach(trelloList -> {
                assertEquals("1", trelloList.getId());
                assertEquals("list_test", trelloList.getName());
                assertFalse(trelloList.isClosed());
            });
        });
    }
    @Test
    public void validateCardTest() {
        //Given
        TrelloCard trelloCard = new TrelloCard("name", "test_description", "test_pos",
                "test_listId");
        TrelloCard trelloCard2 = new TrelloCard("test", "test_description2", "test_pos2",
                "test_listId");
        //when
        trelloValidator.validateCard(trelloCard);
        trelloValidator.validateCard(trelloCard2);
    }

}