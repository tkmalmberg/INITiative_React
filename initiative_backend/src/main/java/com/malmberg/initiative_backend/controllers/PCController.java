package com.malmberg.initiative_backend.controllers;

import com.malmberg.initiative_backend.models.PlayerCharacter;
import com.malmberg.initiative_backend.models.User;
import com.malmberg.initiative_backend.repositories.PCRepository;
import com.malmberg.initiative_backend.repositories.UserRepository;
import com.malmberg.initiative_backend.services.PCService;
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

@Controller
@RequestMapping(path = "/api")
public class PCController {
    private final PCService pcService;
    private final UserService userService;
    private final Logger log = LoggerFactory.getLogger(PlayerCharacter.class);

    public PCController(PCRepository pcRepository, UserRepository userRepository) {
        pcService = new PCService(pcRepository);
        userService = new UserService(userRepository);
    }

    @GetMapping(path="pcs")
    public @ResponseBody Iterable<PlayerCharacter> getAllPCs() {
        return pcService.getAllPCs();
    }

    @GetMapping(path = "pc/{id}")
    public @ResponseBody
    ResponseEntity<?> getPC(@PathVariable Long id) {
        Optional<PlayerCharacter> pc = pcService.getPC(id);
        return pc.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(path = "pc/add")
    ResponseEntity<?> preparePC() throws URISyntaxException {
        PlayerCharacter pc = new PlayerCharacter();
        PlayerCharacter result = pcService.addPC(pc);
        return ResponseEntity.created(new URI("/api/pc/" + result.getId())).body(result);
    }


    @PostMapping(path="pc/add")
    ResponseEntity<PlayerCharacter> createPC(@Valid @RequestBody PlayerCharacter pc) throws URISyntaxException {
        log.info("Request to create Player Character: {}", pc);
        PlayerCharacter result = pcService.addPC(pc);
        return ResponseEntity.created(new URI("api/pc/" + result.getId())).body(result);
    }

    @PutMapping(path = "pc/{id}")
    ResponseEntity<PlayerCharacter> updatePC(@Valid @RequestBody PlayerCharacter pc) {
        log.info("Request to update Player Character: {}", pc);
        PlayerCharacter result = pcService.addPC(pc);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping(path = "pc/{id}")
    public ResponseEntity<?> deletePC(@PathVariable Long id) {
        log.info("Request to delete Player Character: {}", id);
        pcService.deletePC(id);
        return ResponseEntity.ok().build();
    }

}
