package com.crud.tasks.trello.mapper;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloMapperTestSuite {

    @Autowired
    TrelloMapper trelloMapper;

    @Test
    public void mapToBoardsTest() {
        //given
        ArrayList<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(new TrelloListDto("1", "testList", false));
        trelloListDtos.add(new TrelloListDto("2", "testList2", true));

        ArrayList<TrelloListDto> trelloListDtos2 = new ArrayList<>();
        trelloListDtos2.add(new TrelloListDto("3", "testList3", false));
        trelloListDtos2.add(new TrelloListDto("4", "testList4", true));

        ArrayList<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        trelloBoardDtos.add(new TrelloBoardDto("1", "testBoard", trelloListDtos));
        trelloBoardDtos.add(new TrelloBoardDto("2", "testBoard2", trelloListDtos2));
        //when
        List<TrelloBoard> result = trelloMapper.mapToBoards(trelloBoardDtos);
        //then
        Assert.assertEquals(2, result.size());
        Assert.assertEquals("testBoard", result.get(0).getName());
        Assert.assertFalse(result.get(0).getLists().get(0).isClosed());
    }

    @Test
    public void mapToBoardDtoTest() {
        //given
        ArrayList<TrelloList> trelloList = new ArrayList<>();
        trelloList.add(new TrelloList("1", "testList", false));
        trelloList.add(new TrelloList("2", "testList2", true));

        ArrayList<TrelloList> trelloList2 = new ArrayList<>();
        trelloList.add(new TrelloList("3", "testList3", false));
        trelloList.add(new TrelloList("4", "testList4", true));

        ArrayList<TrelloBoard> trelloBoard = new ArrayList<>();
        trelloBoard.add(new TrelloBoard("1", "testBoard", trelloList));
        trelloBoard.add(new TrelloBoard("2", "testBoard2", trelloList2));
        //when
        List<TrelloBoardDto> result = trelloMapper.mapToBoardsDto(trelloBoard);
        //then
        Assert.assertEquals(2, result.size());
        Assert.assertEquals("testBoard", result.get(0).getName());
        Assert.assertFalse(result.get(0).getLists().get(0).isClosed());
    }

    @Test
    public void mapToListTest() {
        //given
        ArrayList<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(new TrelloListDto("1", "testList", false));
        trelloListDtos.add(new TrelloListDto("2", "testList2", true));
        //when
        List<TrelloList> result = trelloMapper.mapToList(trelloListDtos);
        //then
        Assert.assertEquals(2, result.size());
        Assert.assertEquals("testList2", result.get(1).getName());
        Assert.assertFalse(result.get(0).isClosed());
    }

    @Test
    public void mapToListDtoTest() {
        //given
        ArrayList<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("1", "testList", false));
        trelloLists.add(new TrelloList("2", "testList2", true));

        //when
        List<TrelloListDto> result = trelloMapper.mapToListDto(trelloLists);
        //then
        Assert.assertEquals(2, result.size());
        Assert.assertEquals("testList2", result.get(1).getName());
        Assert.assertFalse(result.get(0).isClosed());
    }

    @Test
    public void mapToCardTest() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("testName",
                "testDescription", "testPos", "testListId");
        //When
        TrelloCard result = trelloMapper.mapToCard(trelloCardDto);
        //Then
        Assert.assertEquals("testName", result.getName());
        Assert.assertEquals("testDescription", result.getDescription());
        Assert.assertEquals("testPos", result.getPos());
        Assert.assertEquals("testListId", result.getListId());
    }

   @Test
   public void mapToCardDtoTest() {
       //Given
       TrelloCard trelloCard = new TrelloCard("testName",
               "testDescription", "testPos", "testListId");
       //When
       TrelloCardDto result = trelloMapper.mapToCardDto(trelloCard);
       //Then
       Assert.assertEquals("testName", result.getName());
       Assert.assertEquals("testDescription", result.getDescription());
       Assert.assertEquals("testPos", result.getPos());
       Assert.assertEquals("testListId", result.getListId());
   }
}
