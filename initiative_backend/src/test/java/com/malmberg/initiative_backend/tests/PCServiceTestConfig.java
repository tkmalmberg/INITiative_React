package com.malmberg.initiative_backend.tests;

import com.malmberg.initiative_backend.services.PCService;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("pcServiceTest")
@Configuration
public class PCServiceTestConfig extends SpringBootContextLoader {
    @Bean
    @Primary
    public PCService pcService() {
        return Mockito.mock(PCService.class);
    }
}
