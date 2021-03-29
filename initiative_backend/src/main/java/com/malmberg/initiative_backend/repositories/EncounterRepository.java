package com.malmberg.initiative_backend.repositories;

import com.malmberg.initiative_backend.models.Encounter;
import org.springframework.data.repository.CrudRepository;

public interface EncounterRepository extends CrudRepository<Encounter, Long> {
}
