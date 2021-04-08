package com.malmberg.initiative_backend.repositories;

import com.malmberg.initiative_backend.models.Monster;
import org.springframework.data.repository.CrudRepository;

/**
 * Manages the CRUD operations for the Monster class
 */
public interface MonsterRepository extends CrudRepository<Monster, Long> {
}
