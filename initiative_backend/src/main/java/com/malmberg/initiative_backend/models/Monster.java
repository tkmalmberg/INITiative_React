package com.malmberg.initiative_backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jmx.export.annotation.ManagedAttribute;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The Monster class models the monsters in the INITiative application.
 * Inherits from Creature
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "monster")
public class Monster extends Creature implements Serializable {
    /**
     * Name of the Monster
     */
    @Column(name="name")
    private String name;

    /**
     * Max Hit Points of the Monster
     */
    @Column(name="hitPoints")
    private int hitPoints;

    // TODO May have to create a Current hit points field at some point

    /**
     * Constructor for the Monster Class
     * @param name Name of the Monster
     * @param hitPoints Max hit points of the Monster
     */
    public Monster(String name, int hitPoints) {
        this.name = name;
        this.hitPoints = hitPoints;
    }

    /**
     * Gets the Name of the monster
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Monster
     * @param name The name you want to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the max hit points of the monster
     * @return The max hit points
     */
    public int getHitPoints() {
        return hitPoints;
    }

    /**
     * Sets the max hit points of a monster
     * @param hitPoints The new max hit points
     */
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
}
