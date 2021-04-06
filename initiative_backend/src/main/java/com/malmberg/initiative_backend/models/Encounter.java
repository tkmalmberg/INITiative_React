package com.malmberg.initiative_backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "encounter")
public class Encounter implements Serializable {
    @Id
    @Column(name="eid", nullable=false, length=64)
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(name="name", nullable=false, length=50)
    private String name;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="uid")
    @JsonBackReference
    private User owner;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name ="encounter_combatants",
            joinColumns = {@JoinColumn(name = "eid")},
            inverseJoinColumns = {@JoinColumn(name = "creature_id")}
    )
    @JsonManagedReference
    private Set<Creature> combatants;

    public Encounter() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Set<Creature> getCombatants() {
        return combatants;
    }

    public void setCombatants(Set<Creature> combatants) {
        this.combatants = combatants;
    }
}
