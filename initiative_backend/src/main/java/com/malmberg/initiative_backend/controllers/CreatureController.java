package com.malmberg.initiative_backend.controllers;

import com.malmberg.initiative_backend.models.Creature;
import com.malmberg.initiative_backend.repositories.CreatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/api")
public class CreatureController {
    @Autowired
    private CreatureRepository creatureRepository;

    @GetMapping(path = "creature/all")
    public @ResponseBody Iterable<Creature> getAllCreatures() {
        return creatureRepository.findAll();
    }
}
