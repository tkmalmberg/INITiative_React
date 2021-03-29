package com.malmberg.initiative_backend.repositories;

import com.malmberg.initiative_backend.models.Creature;
import org.springframework.data.repository.CrudRepository;

public interface CreatureRepository extends CrudRepository<Creature, Long> {
}
