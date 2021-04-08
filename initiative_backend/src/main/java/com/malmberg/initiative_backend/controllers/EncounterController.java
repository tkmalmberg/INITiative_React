package com.malmberg.initiative_backend.controllers;

import com.malmberg.initiative_backend.models.Encounter;
import com.malmberg.initiative_backend.repositories.EncounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Controller that manages requests that have to do with Encounter models
 */
@Controller
@RequestMapping(path = "/api")
public class EncounterController {

    // TODO Create an encounter service
    // TODO update this to use ResponseEntity

    @Autowired
    private EncounterRepository encounterRepository;

    /**
     * Adds a new Encounter to the Database
     * @param name The name of the encounter
     * @return
     */
    @PostMapping(path = "encounter/add")
    public @ResponseBody String addNewEncounter(@RequestParam String name) {
        Encounter e = new Encounter();
        e.setName(name);
        encounterRepository.save(e);
        return "Saved";
    }

    @GetMapping(path = "encounters")
    public @ResponseBody Iterable<Encounter> getAllEncounters() {
        return encounterRepository.findAll();
    }
}
