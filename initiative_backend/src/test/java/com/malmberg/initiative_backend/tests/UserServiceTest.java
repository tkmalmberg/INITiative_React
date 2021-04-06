package com.malmberg.initiative_backend.tests;

import com.malmberg.initiative_backend.models.User;
import com.malmberg.initiative_backend.repositories.UserRepository;
import com.malmberg.initiative_backend.services.UserService;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(Parameterized.class)
class UserServiceTest {
    static UserRepository userRepo;
    static UserService userService;

    Long userId;
    User expectedUser;

    public UserServiceTest(Long userId) {
        this.userId = userId;
        this.expectedUser = new User("test1", "test1", false);
    }

    public static Collection params() {
        return Arrays.asList(new Object[][] {
                {1, },
                {2, new User("test2", "test2", false)},
                {3, new User("test3", "test3", false)},
        });
    }

    @BeforeClass
    public static void setup() {
        userService = new UserService(userRepo);
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void test3GetAllUsers() {
        final User[] actualEnd = new User[1];
        User expectedEnd = expectedUser;
        Iterable<User> actual = userService.getAllUsers();
        actual.forEach(new Consumer<User>() {
            @Override
            public void accept(User user) {
                actualEnd[0] = user;
            }
        });
        assertEquals(expectedEnd.toString(), actualEnd[0].toString());
    }

    @Test
    void test2GetUser() {
    }

    @Test
    void test1AddUser() {
    }

    @Test
    void test4DeleteUser() {
    }
}