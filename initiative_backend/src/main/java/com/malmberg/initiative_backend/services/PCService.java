package com.malmberg.initiative_backend.services;

import com.malmberg.initiative_backend.models.PlayerCharacter;
import com.malmberg.initiative_backend.repositories.PCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PCService {

    PCRepository pcRepository;
    @Autowired
    public PCService(PCRepository pcRepository) {
        this.pcRepository = pcRepository;
    }

    public Iterable<PlayerCharacter> getAllPCs() {
        return pcRepository.findAll();
    }

    public Optional<PlayerCharacter> getPC(Long id) {
        return pcRepository.findById(id);
    }

    public PlayerCharacter addPC(PlayerCharacter pc) {
        return pcRepository.save(pc);
    }

    public void deletePC(Long id) {
        pcRepository.deleteById(id);
    }
}
