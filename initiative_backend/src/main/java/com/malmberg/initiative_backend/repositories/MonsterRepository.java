package com.malmberg.initiative_backend.repositories;

import com.malmberg.initiative_backend.models.Monster;
import org.springframework.data.repository.CrudRepository;

public interface MonsterRepository extends CrudRepository<Monster, Long> {
}
