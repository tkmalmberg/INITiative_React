package com.malmberg.initiative_backend.tests;

import com.malmberg.initiative_backend.models.User;
import com.malmberg.initiative_backend.repositories.UserRepository;
import com.malmberg.initiative_backend.services.UserService;
import org.junit.*;
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

@ActiveProfiles("userServiceTest")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MockApp.class, loader = UserServiceTestConfig.class)
@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private final User expectedUser = new User("test1","test1");
    private final Long expId = 1L;
    private final Iterable<User> expIterable = new Iterable<User>() {
        @Override
        public Iterator<User> iterator() {
            return null;
        }
    };

    public UserServiceTest() {
    }

    @Test
    public void testGetAllUsers() {
        Mockito.when(userRepository.findAll()).thenReturn(expIterable);
        Iterable<User> actual = userService.getAllUsers();
        Assert.assertEquals(expIterable, actual);
    }

    @Test
    public void testGetUser() {
        Mockito.when(userRepository.findById(expId)).thenReturn(Optional.of(expectedUser));
        Optional<User> actual = userService.getUser(expId);
        Assert.assertEquals(Optional.of(expectedUser), actual);
    }

    @Test
    public void testAddUser() {
        Mockito.when(userRepository.save(expectedUser)).thenReturn(expectedUser);
        User actual = userService.addUser(expectedUser);
        Assert.assertEquals(expectedUser, actual);
    }

    @Test
    public void testDeleteUser() {
        doNothing().when(userRepository).deleteById(expId);
        userService.deleteUser(expId);
        verify(userRepository, times(1)).deleteById(expId);
    }
}