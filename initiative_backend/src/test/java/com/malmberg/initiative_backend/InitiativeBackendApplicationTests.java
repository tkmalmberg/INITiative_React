package com.malmberg.initiative_backend;

import com.malmberg.initiative_backend.tests.MonsterServiceTest;
import com.malmberg.initiative_backend.tests.PCServiceTest;
import com.malmberg.initiative_backend.tests.UserServiceTest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
		UserServiceTest.class,
		PCServiceTest.class,
		MonsterServiceTest.class
})
@SpringBootTest
public class InitiativeBackendApplicationTests {
}
