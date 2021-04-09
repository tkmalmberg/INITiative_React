package com.malmberg.initiative_backend.repositories;

import com.malmberg.initiative_backend.models.Monster;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Manages the CRUD operations for the Monster class
 */
@Repository
public interface MonsterRepository extends CrudRepository<Monster, Long> {
}
