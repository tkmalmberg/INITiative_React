package com.malmberg.initiative_backend.tests;

import com.malmberg.initiative_backend.models.PlayerCharacter;
import com.malmberg.initiative_backend.repositories.PCRepository;
import com.malmberg.initiative_backend.services.PCService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ActiveProfiles("pcServiceTest")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MockApp.class, loader = PCServiceTestConfig.class)
@SpringBootTest
public class PCServiceTest {

    @Mock
    private PCRepository pcRepository;

    @InjectMocks
    private PCService pcService;

    private final PlayerCharacter expPC = new PlayerCharacter("test", "test", "test", 0, 0);
    private final Long expId = 1L;
    private final Iterable<PlayerCharacter> expIterable = new Iterable<PlayerCharacter>() {
        @Override
        public Iterator<PlayerCharacter> iterator() {
            return null;
        }
    };

    public PCServiceTest() {
    }

    @Test
    public void testGetAllPCs() {
        Mockito.when(pcRepository.findAll()).thenReturn(expIterable);
        Iterable<PlayerCharacter> actual = pcService.getAllPCs();
        Assert.assertEquals(expIterable, actual);
    }

    @Test
    public void testGetPC() {
        Mockito.when(pcRepository.findById(expId)).thenReturn(Optional.of(expPC));
        Optional<PlayerCharacter> actual = pcService.getPC(expId);
        Assert.assertEquals(Optional.of(expPC), actual);
    }

    @Test
    public void testAddPC() {
        Mockito.when(pcRepository.save(expPC)).thenReturn(expPC);
        PlayerCharacter actual = pcService.addPC(expPC);
        Assert.assertEquals(expPC, actual);
    }

    @Test
    public void testDeletePC() {
        doNothing().when(pcRepository).deleteById(expId);
        pcService.deletePC(expId);
        verify(pcRepository, times(1)).deleteById(expId);
    }

}
