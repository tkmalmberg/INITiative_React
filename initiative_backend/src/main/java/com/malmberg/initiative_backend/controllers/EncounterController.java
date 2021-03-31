package com.malmberg.initiative_backend.controllers;

import com.malmberg.initiative_backend.models.Encounter;
import com.malmberg.initiative_backend.repositories.EncounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api")
public class EncounterController {
    @Autowired
    private EncounterRepository encounterRepository;

    @PostMapping(path = "encounter/add")
    public @ResponseBody String addNewEncounter(@RequestParam String name) {
        Encounter e = new Encounter();
        e.setName(name);
        encounterRepository.save(e);
        return "Saved";
    }

    @GetMapping(path = "encounter/all")
    public @ResponseBody Iterable<Encounter> getAllEncounters() {
        return encounterRepository.findAll();
    }
}
