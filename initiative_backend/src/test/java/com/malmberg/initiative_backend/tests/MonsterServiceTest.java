package com.malmberg.initiative_backend.tests;

import com.malmberg.initiative_backend.models.Monster;
import com.malmberg.initiative_backend.repositories.MonsterRepository;
import com.malmberg.initiative_backend.services.MonsterService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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

    @Mock
    private MonsterRepository monsterRepository;

    @InjectMocks
    private MonsterService monsterService;

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
        when(monsterRepository.findAll()).thenReturn(expIterable);
        Iterable<Monster> actual = monsterService.getAllMonsters();
        Assert.assertEquals(expIterable, actual);
    }

    @Test
    public void testGetMonster() {
        when(monsterRepository.findById(expId)).thenReturn(Optional.of(expMonster));
        Optional<Monster> actual = monsterService.getMonster(expId);
        Assert.assertEquals(Optional.of(expMonster), actual);
    }

    @Test
    public void testAddMonster() {
        when(monsterRepository.save(expMonster)).thenReturn(expMonster);
        Monster actual = monsterService.addMonster(expMonster);
        Assert.assertEquals(expMonster, actual);
    }

    @Test
    public void testDeleteMonster() {
        doNothing().when(monsterRepository).deleteById(expId);
        monsterService.deleteMonster(expId);
        verify(monsterRepository, times(1)).deleteById(expId);
    }


}
