package com.malmberg.initiative_backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * The Encounter Class models the encounter functions for the INITitative application
 */
@Entity
@Table(name = "encounter")
public class Encounter implements Serializable {

    /**
     * The ID of the Encounter
     */
    @Id
    @Column(name="eid", nullable=false, length=64)
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    /**
     * The Name of the Encounter
     */
    @Column(name="name", nullable=false, length=50)
    private String name;

//    @ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name="uid")
//    @JsonBackReference
//    private User owner;

    /**
     * The Set of Creatures that are stored in the Encounter
     */
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name ="encounter_combatants",
            joinColumns = {@JoinColumn(name = "eid")},
            inverseJoinColumns = {@JoinColumn(name = "creature_id")}
    )
    private Set<Creature> combatants;

    /**
     * Empty constructor for the Encounter class
     */
    public Encounter() {
    }

    /**
     * Gets the Id of the Encounter
     * @return The Id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the Id of the Encounter
     * @param id The Id you want to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of the Encounter
     * @return The Name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Encounter
     * @param name The name you want to set
     */
    public void setName(String name) {
        this.name = name;
    }

//    public User getOwner() {
//        return owner;
//    }
//
//    public void setOwner(User owner) {
//        this.owner = owner;
//    }

    /**
     * Gets the creatures that are stored in the encounter
     * @return A Set of Creatures
     */
    public Set<Creature> getCombatants() {
        return combatants;
    }

    /**
     * Sets the Set of combatants to a new set
     * @param combatants The Set you want to set
     */
    public void setCombatants(Set<Creature> combatants) {
        this.combatants = combatants;
    }
}
