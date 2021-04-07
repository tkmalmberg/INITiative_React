package com.malmberg.initiative_backend.tests;

import com.malmberg.initiative_backend.services.UserService;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("userServiceTest")
@Configuration
public class UserServiceTestConfig extends SpringBootContextLoader {
    @Bean
    @Primary
    public UserService userService() {
        return Mockito.mock(UserService.class);
    }
}
