package com.malmberg.initiative_backend.tests;

import com.malmberg.initiative_backend.services.MonsterService;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("monsterServiceTest")
@Configuration
public class MonsterServiceTestConfig extends SpringBootContextLoader {
    @Bean
    @Primary
    public MonsterService monsterService() {
        return Mockito.mock(MonsterService.class);
    }
}
