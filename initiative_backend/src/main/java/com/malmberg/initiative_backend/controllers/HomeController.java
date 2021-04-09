package com.malmberg.initiative_backend.controllers;

import com.malmberg.initiative_backend.models.User;
import com.malmberg.initiative_backend.repositories.UserRepository;
import com.malmberg.initiative_backend.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Controller that handles session related requests, like logging in and registering
 */
@RestController
@RequestMapping(path = "/")
public class HomeController {

    /**
     * The UserService communicates with the UserRepository
     */
    private final UserService userService;

    /**
     * Logs interactions into the console. This is mostly for bookkeeping's sake
     */
    private final Logger log = LoggerFactory.getLogger(HomeController.class);

    /**
     * Constructor for the HomeController
     * @param userRepository The UserRepository that the UserService will be using
     */
    public HomeController(UserRepository userRepository) {
        userService = new UserService(userRepository);
    }

    @PostMapping(path = "/register")
    public ResponseEntity<User> registerUser(@Valid @RequestBody User user) throws URISyntaxException {
        log.info("Request to Register User: {}", user);
//        User newUser = new User(email, password);
        User result = userService.addUser(user);
        return ResponseEntity.created(new URI("api/user/" + result.getId())).body(result);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<User> loginUser(@Valid @RequestBody User user) {
        return null;
    }
}
