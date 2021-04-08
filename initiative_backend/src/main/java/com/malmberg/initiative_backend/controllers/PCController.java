package com.malmberg.initiative_backend.controllers;

import com.malmberg.initiative_backend.models.PlayerCharacter;
import com.malmberg.initiative_backend.repositories.PCRepository;
import com.malmberg.initiative_backend.services.PCService;
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
 * Controller that manages requests that have to do with PlayerCharacter models
 */
@Controller
@RequestMapping(path = "/api")
public class PCController {

    /**
     * The PCService communicates with the PCRepository
     */
    private final PCService pcService;

    /**
     * Logs interactions into the console. This is mostly for bookkeeping's sake
     */
    private final Logger log = LoggerFactory.getLogger(PlayerCharacter.class);

    /**
     * Constructor for the PCController
     * @param pcRepository The PCRepository that the PCService will be using
     */
    public PCController(PCRepository pcRepository) {
        pcService = new PCService(pcRepository);
    }

    /**
     * Gets all of the PlayerCharacters from the Database when /pcs is routed to
     * @return An Iterable of PlayerCharacters
     */
    @GetMapping(path="pcs")
    public @ResponseBody Iterable<PlayerCharacter> getAllPCs() {
        return pcService.getAllPCs();
    }

    /**
     * Gets a specific PlayerCharacter by ID
     * @param id The ID of the PlayerCharacter you want to find
     * @return Returns a ResponseEntity containing a JSON of the found PlayerCharacter
     */
    @GetMapping(path = "pc/{id}")
    public @ResponseBody
    ResponseEntity<?> getPC(@PathVariable Long id) {
        Optional<PlayerCharacter> pc = pcService.getPC(id);
        return pc.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Prepares a PlayerCharacter for the front end
     * @return Returns a ResponseEntity of the created PlayerCharacter and the new URI
     * @throws URISyntaxException Throws exception if there's a syntax error in the URI
     */
    @GetMapping(path = "pc/add")
    ResponseEntity<?> preparePC() throws URISyntaxException {
        PlayerCharacter pc = new PlayerCharacter();
        PlayerCharacter result = pcService.addPC(pc);

        return ResponseEntity.created(new URI("/api/pc/" + result.getId())).body(result);
    }

    /**
     * Creates a PlayerCharacter
     * @param pc The PlayerCharacter to be created
     * @return Returns a ResponseEntity of the created PlayerCharacter and the new URI
     * @throws URISyntaxException Throws exception if there's a syntax error in the URI
     */
    @PostMapping(path="pc/add")
    ResponseEntity<PlayerCharacter> createPC(@Valid @RequestBody PlayerCharacter pc) throws URISyntaxException {
        log.info("Request to create Player Character: {}", pc);
        PlayerCharacter result = pcService.addPC(pc);
        return ResponseEntity.created(new URI("api/pc/" + result.getId())).body(result);
    }

    /**
     * Updates a specific PlayerCharacter
     * @param pc The PlayerCharacter you want to update
     * @return Return a ResponseEntity that gives a 200 report
     */
    @PutMapping(path = "pc/{id}")
    ResponseEntity<PlayerCharacter> updatePC(@Valid @RequestBody PlayerCharacter pc) {
        log.info("Request to update Player Character: {}", pc);
        PlayerCharacter result = pcService.addPC(pc);
        return ResponseEntity.ok().body(result);
    }

    /**
     * Deletes a specific PlayerCharacter
     * @param id The ID of the PlayerCharacter you want to delete
     * @return Returns a ResponseEntity that give a 200 report
     */
    @DeleteMapping(path = "pc/{id}")
    public ResponseEntity<?> deletePC(@PathVariable Long id) {
        log.info("Request to delete Player Character: {}", id);
        pcService.deletePC(id);
        return ResponseEntity.ok().build();
    }

}
