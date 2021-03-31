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

@Controller
@RequestMapping(path = "/pc")
public class PCController {
    private final PCService pcService;
    private final Logger log = LoggerFactory.getLogger(PlayerCharacter.class);

    public PCController(PCRepository pcRepository) {
        pcService = new PCService(pcRepository);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<PlayerCharacter> getAllPCs() {
        // This returns a JSON or XML with the PC's
        return pcService.getAllPCs();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<?> getPC(@PathVariable Long id) {
        Optional<PlayerCharacter> pc = pcService.getPC(id);
        return pc.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(path="/add")
    ResponseEntity<PlayerCharacter> createPC(@Valid @RequestBody PlayerCharacter pc) throws URISyntaxException {
        log.info("Request to create Player Character: {}", pc);
        PlayerCharacter result = pcService.addPC(pc);
        return ResponseEntity.created(new URI("/pc/" + result.getId())).body(result);
    }

    @PutMapping(path = "/{id}")
    ResponseEntity<PlayerCharacter> updatePC(@Valid @RequestBody PlayerCharacter pc) {
        log.info("Request to create Player Character: {}", pc);
        PlayerCharacter result = pcService.addPC(pc);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deletePC(@PathVariable Long id) {
        log.info("Request to delete Player Character: {}", id);
        pcService.deletePC(id);
        return ResponseEntity.ok().build();
    }

}
