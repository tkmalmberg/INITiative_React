package com.malmberg.initiative_backend.services;

import com.malmberg.initiative_backend.models.PlayerCharacter;
import com.malmberg.initiative_backend.repositories.PCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * The service level implementation of the PCRepository
 */
@Service
public class PCService {

    PCRepository pcRepository;

    /**
     * Constructor for PlayerCharacter Service implementation
     * @param pcRepository PlayerCharacter Repository
     */
    @Autowired
    public PCService(PCRepository pcRepository) {
        this.pcRepository = pcRepository;
    }

    /**
     * Service implementation of pcRepository.findAll()
     * @return An Iterable of PlayerCharacter
     */
    public Iterable<PlayerCharacter> getAllPCs() {
        return pcRepository.findAll();
    }

    /**
     * Service implementation of pcRepository.findById()
     * @param id The id of the PlayerCharacter you want to find
     * @return An optional of the PlayerCharacter
     */
    public Optional<PlayerCharacter> getPC(Long id) {
        return pcRepository.findById(id);
    }

    /**
     * Service implementation of pcRepository.save()
     * @param pc The PlayerCharacter you want to add to the database
     * @return A PlayerCharacter object
     */
    public PlayerCharacter addPC(PlayerCharacter pc) {
        return pcRepository.save(pc);
    }

    /**
     * Service implementation of pcRepository.deleteById()
     * @param id The id of the PlayerCharacter you want to delete
     */
    public void deletePC(Long id) {
        pcRepository.deleteById(id);
    }
}
