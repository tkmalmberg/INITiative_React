package com.malmberg.initiative_backend.controllers;

import com.malmberg.initiative_backend.models.Monster;
import com.malmberg.initiative_backend.repositories.MonsterRepository;
import com.malmberg.initiative_backend.services.MonsterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

/**
 * Controller that manages requests that have to do with Monster models
 */
@RestController
@RequestMapping(path = "/api")
public class MonsterController {

    /**
     * The MonsterService communicates with the MonsterRepository
     */
    private final MonsterService monsterService;

    /**
     * Logs interactions into the console. This is mostly for bookkeeping's sake
     */
    private static final Logger log = LoggerFactory.getLogger(MonsterController.class);

    /**
     * Constructor for the Monster Controller
     * @param monsterRepository The MonsterRepository that the MonsterService will be using
     */
    public MonsterController(MonsterRepository monsterRepository) {
        monsterService = new MonsterService(monsterRepository);
    }

    /**
     * Gets all of the Monsters from the Database when /monsters is routed to
     * @return The Iterable of Monsters
     */
    @GetMapping(path="monsters")
    public @ResponseBody Iterable<Monster> getAllMonsters() {
        return monsterService.getAllMonsters();
    }

    /**
     * Gets a specific Monster by ID
     * @param id The ID of the Monster you want to find
     * @return Returns a ResponseEntity containing a JSON of the found Monster
     */
    @GetMapping(path = "monster/{id}")
    ResponseEntity<?> getMonster(@PathVariable Long id) {
        Optional<Monster> mon = monsterService.getMonster(id);
        return mon.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Prepares a Monster for the front end
     * @return Returns a ResponseEntity of the created Monster and the new URI
     * @throws URISyntaxException Throws exception if there's a syntax error in the URI
     */
    @GetMapping(path = "monster/add")
    ResponseEntity<?> prepareMonster() throws URISyntaxException {
        Monster mon = new Monster();
        Monster result = monsterService.addMonster(mon);
        return ResponseEntity.created(new URI("/api/monster/" + result.getId())).body(result);
    }

    /**
     * Creates a Monster
     * @param mon The Monster to be created
     * @return Returns a ResponseEntity of the created Monster and the new URI
     * @throws URISyntaxException Throws exception if there's a syntax error in the URI
     */
    @PostMapping(path="monster/add") // Map ONLY POST Requests
    ResponseEntity<Monster> createMonster(@Valid @RequestBody Monster mon) throws URISyntaxException {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        log.info("Request to create Monster: {}", mon);
        Monster result = monsterService.addMonster(mon);
        return ResponseEntity.created(new URI("/api/monster/" + result.getId())).body(result);
    }

    /**
     * Updates a specific Monster
     * @param mon The Monster you want to update
     * @return Return a ResponseEntity that gives a 200 report
     */
    @PutMapping(path = "monster/{id}")
    ResponseEntity<Monster> updateMonster(@Valid @RequestBody Monster mon) {
        log.info("Request to update Monster: {}", mon);
        Monster result = monsterService.addMonster(mon);
        return ResponseEntity.ok().body(result);
    }

    /**
     * Deletes a specific Monster
     * @param id The ID of the Monster you want to delete
     * @return Returns a ResponseEntity that give a 200 report
     */
    @DeleteMapping(path = "monster/{id}")
    public ResponseEntity<?> deleteMonster(@PathVariable Long id) {
        log.info("Request to delete Monster: {}", id);
        monsterService.deleteMonster(id);
        return ResponseEntity.ok().build();
    }
}
