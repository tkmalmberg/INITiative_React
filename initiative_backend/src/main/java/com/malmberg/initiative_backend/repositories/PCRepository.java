package com.malmberg.initiative_backend.repositories;

import com.malmberg.initiative_backend.models.PlayerCharacter;
import org.springframework.data.repository.CrudRepository;

public interface PCRepository extends CrudRepository<PlayerCharacter, Long> {
}
