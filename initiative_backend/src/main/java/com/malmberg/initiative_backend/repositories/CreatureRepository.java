package com.malmberg.initiative_backend.repositories;

import com.malmberg.initiative_backend.models.Creature;
import org.springframework.data.repository.CrudRepository;

/**
 * Manages the CRUD operations for the Creature class
 */
public interface CreatureRepository extends CrudRepository<Creature, Long> {
}
