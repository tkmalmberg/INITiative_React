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

@Controller
@RequestMapping(path = "/api")
public class MonsterController {
    private final MonsterService monsterService;
    private final Logger log = LoggerFactory.getLogger(MonsterController.class);

    public MonsterController(MonsterRepository monsterRepository) {
        monsterService = new MonsterService(monsterRepository);
    }

    @GetMapping(path="monster/all")
    public @ResponseBody Iterable<Monster> getAllMonsters() {
        // This returns a JSON or XML with the users
        return monsterService.getAllMonsters();
    }

    @GetMapping(path = "monster/{id}")
    ResponseEntity<?> getMonster(@PathVariable Long id) {
        Optional<Monster> mon = monsterService.getMonster(id);
        return mon.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(path = "monster/add")
    ResponseEntity<?> prepareMonster() throws URISyntaxException {
        Monster mon = new Monster();
        Monster result = monsterService.addMonster(mon);
        return ResponseEntity.created(new URI("/monster/" + result.getId())).body(result);
    }

    @PostMapping(path="monster/add") // Map ONLY POST Requests
    ResponseEntity<Monster> createMonster(@Valid @RequestBody Monster mon) throws URISyntaxException {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        log.info("Request to create Monster: {}", mon);
        Monster result = monsterService.addMonster(mon);
        return ResponseEntity.created(new URI("/monster/" + result.getId())).body(result);
    }

    @PutMapping(path = "monster/{id}")
    ResponseEntity<Monster> updateMonster(@Valid @RequestBody Monster mon) {
        log.info("Request to update Monster: {}", mon);
        Monster result = monsterService.addMonster(mon);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping(path = "monster/{id}")
    public ResponseEntity<?> deleteMonster(@PathVariable Long id) {
        log.info("Request to delete Monster: {}", id);
        monsterService.deleteMonster(id);
        return ResponseEntity.ok().build();
    }
}
