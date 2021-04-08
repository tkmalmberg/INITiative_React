package com.malmberg.initiative_backend.repositories;

import com.malmberg.initiative_backend.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Manages the CRUD operations for the Creature class
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
