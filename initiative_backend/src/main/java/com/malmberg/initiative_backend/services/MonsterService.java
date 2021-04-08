package com.malmberg.initiative_backend.services;

import com.malmberg.initiative_backend.models.Monster;
import com.malmberg.initiative_backend.repositories.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * The service level implementation of the MonsterRepository
 */
@Service
public class MonsterService {

    private MonsterRepository monsterRepository;

    /**
     * Constructor for Monster Service implementation
     * @param monsterRepository Monster Repository
     */
    @Autowired
    public MonsterService(MonsterRepository monsterRepository) {
        this.monsterRepository = monsterRepository;
    }

    /**
     * Service implementation of monsterRepository.findAll()
     * @return An Iterable of Monster
     */
    public Iterable<Monster> getAllMonsters() {
        return monsterRepository.findAll();
    }

    /**
     * Service implementation of monsterRepository.findById()
     * @param id The id of the Monster you want to find
     * @return An optional of the Monster
     */
    public Optional<Monster> getMonster(Long id) {
        return monsterRepository.findById(id);
    }

    /**
     * Service implementation of monsterRepository.save()
     * @param mon The Monster you want to add to the database
     * @return A Monster object
     */
    public Monster addMonster(Monster mon) {
        return monsterRepository.save(mon);
    }

    /**
     * Service implementation of monsterRepository.deleteById()
     * @param id The id of the Monster you want to delete
     */
    public void deleteMonster(Long id) {
        monsterRepository.deleteById(id);
    }

}
