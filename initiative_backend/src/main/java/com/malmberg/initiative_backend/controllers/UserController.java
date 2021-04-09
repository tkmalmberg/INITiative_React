package com.malmberg.initiative_backend.controllers;

import com.malmberg.initiative_backend.models.User;
import com.malmberg.initiative_backend.repositories.UserRepository;
import com.malmberg.initiative_backend.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

/**
 * Controller that manages requests that have to do with User models
 */
@Controller
@RequestMapping(path="/api")
public class UserController {

    /**
     * The UserService communicates with the UserRepository
     */
    private final UserService userService;

    /**
     * Logs interactions into the console. This is mostly for bookkeeping's sake
     */
    private final Logger log = LoggerFactory.getLogger(UserController.class);

    /**
     * Constructor for the UserController
     * @param userRepository The UserRepository that the UserService will be using
     */
    public UserController(UserRepository userRepository) {
        userService = new UserService(userRepository);
    }

    /**
     * Gets all of the Users from the Database when /users is routed to
     * @return An Iterable of Users
     */
    @GetMapping(path="users")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userService.getAllUsers();
    }

    /**
     * Gets a specific User by ID
     * @param id The ID of the User you want to find
     * @return Returns a ResponseEntity containing a JSON of the found User
     */
    @GetMapping(path = "user/{id}")
    ResponseEntity<?> getUser(@PathVariable Long id) {
        Optional<User> user = userService.getUser(id);
        return user.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Creates a User
     * @param user The User to be added to the Database
     * @return Returns a ResponseEntity of the created User and the new URI
     * @throws URISyntaxException Throws exception if there's a syntax error in the URI
     */
    @PostMapping(path="user/add")
    ResponseEntity<User> createUser(@Valid @RequestBody User user) throws URISyntaxException {
        log.info("Request to create User: {}", user);
        User result = userService.addUser(user);
        return ResponseEntity.created(new URI("api/user/" + result.getId())).body(result);
    }

    /**
     * Updates a specific User
     * @param user The user you want to update
     * @return Return a ResponseEntity that gives a 200 report
     */
    @PutMapping(path = "user/{id}")
    ResponseEntity<User> updateUser(@Valid @RequestBody User user) {
        log.info("Request to update User: {}", user);
        User result = userService.addUser(user);
        return ResponseEntity.ok().body(result);
    }

    /**
     * Deletes a specific User
     * @param id The ID of the User you want to delete
     * @return Returns a ResponseEntity that give a 200 report
     */
    @DeleteMapping(path = "user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        log.info("Request to delete User: {}", id);
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

//    @GetMapping(path = "/pc/add/{id}")
//    ResponseEntity<?> preparePC(@PathVariable Long id) throws URISyntaxException {
//        User currentUser = userService.getUser(id).get();
//        currentUser.getPcs().add(new PlayerCharacter());
//        PlayerCharacter result = currentUser.getPcs().get(currentUser.getPcs().size());
//        return ResponseEntity.created(new URI("/api/pc/" + result.getId())).body(result);
//    }

}
