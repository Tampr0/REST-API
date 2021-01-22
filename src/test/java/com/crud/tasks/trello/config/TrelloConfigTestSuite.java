package com.crud.tasks.trello.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloConfigTestSuite {

    @Autowired
    private TrelloConfig trelloConfig;

    @Test
    public void propertyValuesTest() {
        //Given
        //When
        String property = trelloConfig.getTrelloApiEndpoint();
        String property2 = trelloConfig.getTrelloAppKey();
        String property3 = trelloConfig.getTrelloToken();
        //Then
        assertEquals("https://api.trello.com/1", property);
        assertEquals("8bbfe251f62b63a4a049cb2f8b6b8976", property2);
        assertEquals("86a95e678acdd8d35bf19ab2a4f40e8d0d36c7db58554b9606531399af91bbe1", property3);
    }


}