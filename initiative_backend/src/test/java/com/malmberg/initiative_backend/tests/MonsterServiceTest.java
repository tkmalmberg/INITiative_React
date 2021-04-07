package com.malmberg.initiative_backend.tests;

import com.malmberg.initiative_backend.models.Monster;
import com.malmberg.initiative_backend.services.MonsterService;
import com.malmberg.initiative_backend.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ActiveProfiles("monsterServiceTest")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MockApp.class, loader = MonsterServiceTestConfig.class)
@SpringBootTest
public class MonsterServiceTest {

    @Autowired
    private MonsterService monsterService = mock(MonsterService.class);

    private final Monster expMonster = new Monster("test",0);
    private final Long expId = 1L;
    private final Iterable<Monster> expIterable = new Iterable<Monster>() {
        @Override
        public Iterator<Monster> iterator() {
            return null;
        }
    };

    public MonsterServiceTest() {
    }

    @Test
    public void testGetAllMonsters() {
        Mockito.when(monsterService.getAllMonsters()).thenReturn(expIterable);
        Iterable<Monster> actual = monsterService.getAllMonsters();
        Assert.assertEquals(expIterable, actual);
    }

    @Test
    public void testGetMonster() {
        Mockito.when(monsterService.getMonster(expId)).thenReturn(Optional.of(expMonster));
        Optional<Monster> actual = monsterService.getMonster(expId);
        Assert.assertEquals(Optional.of(expMonster), actual);
    }

    @Test
    public void testAddMonster() {
        Mockito.when(monsterService.addMonster(expMonster)).thenReturn(expMonster);
        Monster actual = monsterService.addMonster(expMonster);
        Assert.assertEquals(expMonster, actual);
    }

    @Test
    public void testDeleteMonster() {
        doNothing().when(monsterService).deleteMonster(expId);
        monsterService.deleteMonster(expId);
        verify(monsterService, times(1)).deleteMonster(expId);
    }


}
