package com.malmberg.initiative_backend.tests;

import com.malmberg.initiative_backend.models.User;
import com.malmberg.initiative_backend.services.UserService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserService userService = mock(UserService.class);

    private final User expectedUser = new User("test1","test1", false);
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
        Mockito.when(userService.getAllUsers()).thenReturn(expIterable);
        Iterable<User> actual = userService.getAllUsers();
        Assert.assertEquals(expIterable, actual);
    }

    @Test
    public void testGetUser() {
        Mockito.when(userService.getUser(expId)).thenReturn(Optional.of(expectedUser));
        Optional<User> actual = userService.getUser(expId);
        Assert.assertEquals(Optional.of(expectedUser), actual);
    }

    @Test
    public void testAddUser() {
        Mockito.when(userService.addUser(expectedUser)).thenReturn(expectedUser);
        User actual = userService.addUser(expectedUser);
        Assert.assertEquals(expectedUser, actual);
    }

    @Test
    public void testDeleteUser() {
        doNothing().when(userService).deleteUser(expId);
        userService.deleteUser(expId);
        verify(userService,times(1)).deleteUser(expId);
    }
}