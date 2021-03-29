package com.malmberg.initiative_backend.controllers;

import com.malmberg.initiative_backend.models.PlayerCharacter;
import com.malmberg.initiative_backend.repositories.PCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/pc")
public class PCController {
    @Autowired
    private PCRepository pcRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewPc(@RequestParam String name) {
        PlayerCharacter pc = new PlayerCharacter();
        pc.setName(name);
        pcRepository.save(pc);
        return "Saved";
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<?> getPC(@PathVariable Long id) {
        Optional<PlayerCharacter> pc = pcRepository.findById(id);
        return pc.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<PlayerCharacter> getAllPCs() {
        // This returns a JSON or XML with the PC's
        return pcRepository.findAll();
    }
}
