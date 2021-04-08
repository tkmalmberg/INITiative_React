package com.malmberg.initiative_backend.repositories;

import com.malmberg.initiative_backend.models.PlayerCharacter;
import org.springframework.data.repository.CrudRepository;

/**
 * Manages the CRUD operations for the PlayerCharacter class
 */
public interface PCRepository extends CrudRepository<PlayerCharacter, Long> {
}
