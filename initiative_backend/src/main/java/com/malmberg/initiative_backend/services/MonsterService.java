package com.malmberg.initiative_backend.services;

import com.malmberg.initiative_backend.models.Monster;
import com.malmberg.initiative_backend.repositories.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MonsterService {
    @Autowired
    private MonsterRepository monsterRepository;

    public MonsterService(MonsterRepository monsterRepository) {
        this.monsterRepository = monsterRepository;
    }

    public Iterable<Monster> getAllMonService() {
        return monsterRepository.findAll();
    }

    public Optional<Monster> getMonster(Long id) {
        return monsterRepository.findById(id);
    }

    public Monster addMonster(Monster mon) {
        return monsterRepository.save(mon);
    }

    public void deleteMonster(Long id) {
        monsterRepository.deleteById(id);
    }

}
