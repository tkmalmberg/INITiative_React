package com.malmberg.initiative_backend.controllers;

import com.malmberg.initiative_backend.models.Monster;
import com.malmberg.initiative_backend.repositories.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/monster")
public class MonsterController {
    @Autowired
    private MonsterRepository monsterRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewMonster(@RequestParam String name) {
        Monster m = new Monster();
        m.setName(name);
        monsterRepository.save(m);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Monster> getAllMonsters() {
        // This returns a JSON or XML with the users
        return monsterRepository.findAll();
    }
}
