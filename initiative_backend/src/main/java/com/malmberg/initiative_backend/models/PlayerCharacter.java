package com.malmberg.initiative_backend.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The PlayerCharacter class models the player character in the
 * INITiative application
 * Inherits from Creature
 */
@Entity
@Table(name = "player_character")
public class PlayerCharacter extends Creature implements Serializable{

    /**
     * Name of the PlayerCharacter
     */
    @Column(name="name")
    private String name = "";

    /**
     * Race of the PlayerCharacter (ex. Human, Elf, Dwarf, etc.)
     */
    @Column(name="race")
    private String race = "";

    /**
     * Class of the PlayerCharacter (ex. Barbarian, Wizard, Bard, etc.)
     */
    @Column(name="class")
    private String className = "";

    /**
     * The Hit Point max of the Player Character
     */
    @Column(name="hitPoints")
    private int hitPoints = 0;

    /**
     * The level of the PlayerCharacter
     */
    @Column(name="charLevel")
    private int level = 0;

//    @ManyToMany(mappedBy = "pcs")
//    @JsonProperty
//    private List<User> player;

    /**
     * Empty constructor for the PlayerCharacter class
     */
    public PlayerCharacter() {
    }

    /**
     * Constructor for the PlayerCharacter class
     * @param name PlayerCharacter's name
     * @param race Race of the PlayerCharacter
     * @param className Class of the PlayerCharacter
     * @param hitPoints The Current Hit Point max of the PlayerCharacter
     * @param level Level of the PlayerCharacter
     */
    public PlayerCharacter(String name, String race, String className, int hitPoints, int level) {
        this.name = name;
        this.race = race;
        this.className = className;
        this.hitPoints = hitPoints;
        this.level = level;
    }

    /**
     * Gets the Name
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the Name
     * @param name Name you want to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the Race
     * @return The race
     */
    public String getRace() {
        return race;
    }

    /**
     * Sets the Race
     * @param race Race you want to set
     */
    public void setRace(String race) {
        this.race = race;
    }

    /**
     * Gets the Class
     * @return The class
     */
    public String getClassName() {
        return className;
    }

    /**
     * Sets the class
     * @param className The class you want to set
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * Gets Hit Points
     * @return The total hit points
     */
    public int getHitPoints() {
        return hitPoints;
    }

    /**
     * Sets new hit point max
     * @param hitPoints The new hit point max
     */
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    /**
     * Gets the character level
     * @return The character level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Sets the Character level
     * @param level The level you want to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

//    public List<User> getPlayer() {
//        return player;
//    }
//
//    public void setPlayer(List<User> player) {
//        this.player = player;
//    }
}
