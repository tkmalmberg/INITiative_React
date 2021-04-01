package com.malmberg.initiative_backend.controllers;

import com.malmberg.initiative_backend.models.PlayerCharacter;
import com.malmberg.initiative_backend.models.User;
import com.malmberg.initiative_backend.repositories.PCRepository;
import com.malmberg.initiative_backend.repositories.UserRepository;
import com.malmberg.initiative_backend.services.PCService;
import com.malmberg.initiative_backend.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@Controller // This means that this class is a Controller
@RequestMapping(path="/api") // This means URL's start with /user (after Application path)
public class UserController {
    private final UserService userService;
    private final PCService pcService;
    private final Logger log = LoggerFactory.getLogger(UserController.class);

    public UserController(UserRepository userRepository, PCRepository pcRepository) {
        userService = new UserService(userRepository);
        pcService = new PCService(pcRepository);
    }

    @GetMapping(path="users")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userService.getAllUsers();
    }

    @GetMapping(path = "user/{id}")
    ResponseEntity<?> getUser(@PathVariable Long id) {
        Optional<User> user = userService.getUser(id);
        return user.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(path="user/add") // Map ONLY POST Requests
    ResponseEntity<User> createUser(@Valid @RequestBody User user) throws URISyntaxException {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        log.info("Request to create User: {}", user);
        User result = userService.addUser(user);
        return ResponseEntity.created(new URI("api/user/" + result.getId())).body(result);
    }

    @PutMapping(path = "user/{id}")
    ResponseEntity<User> updateUser(@Valid @RequestBody User user) {
        log.info("Request to update User: {}", user);
        User result = userService.addUser(user);
        return ResponseEntity.ok().body(result);
    }

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
