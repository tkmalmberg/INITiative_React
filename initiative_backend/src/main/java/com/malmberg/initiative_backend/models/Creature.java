package com.malmberg.initiative_backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Serves as the base class for both Monsters and PlayerCharacters to inherit from
 */
@Entity
@Table(name = "creature")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Creature {

    /**
     * The ID of the Creature
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="creature_id", updatable=false, nullable=false)
    protected Long id;

    /**
     * Strength of the Creature
     */
    @Column(name="strength")
    protected int strength = 10;

    /**
     * Constitution of the Creature
     */
    @Column(name="constitution")
    protected int constitution = 10;

    /**
     * Dexterity of the Creature
     */
    @Column(name="dexterity")
    protected int dexterity = 10;

    /**
     * Intelligence of the Creature
     */
    @Column(name="intelligence")
    protected int intelligence = 10;

    /**
     * Wisdom of the Creature
     */
    @Column(name="wisdom")
    protected int wisdom = 10;

    /**
     * Charisma of the Creature
     */
    @Column(name="charisma")
    protected int charisma = 10;

    /**
     * The List of encounters a creature is involved in
     */
    @ManyToMany(mappedBy = "combatants")
    private List<Encounter> encounters;

    /**
     * Empty constructor for the Creature class
     */
    public Creature() { }

    /**
     * Constructor for the Creature class
     * @param strength Strength of the Creature
     * @param constitution Constitution of the Creature
     * @param dexterity Dexterity of the Creature
     * @param intelligence Intelligence of the Creature
     * @param wisdom Wisdom of the Creature
     * @param charisma Charisma of the Creature
     */
    public Creature(int strength, int constitution, int dexterity, int intelligence, int wisdom, int charisma) {
        this.strength = strength;
        this.constitution = constitution;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    /**
     * Gets the ID
     * @return The ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Gets the Strength Attribute
     * @return The Strength Attribute
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Sets the Strength Attribute
     * @param strength The Strength you want to set
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * Gets the Constitution Attribute
     * @return The Constitution Attribute
     */
    public int getConstitution() {
        return constitution;
    }

    /**
     * Sets the Constitution Attribute
     * @param constitution The Constitution you want to set
     */
    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    /**
     * Gets the Dexterity Attribute
     * @return The Dexterity Attribute
     */
    public int getDexterity() {
        return dexterity;
    }

    /**
     * Sets the Dexterity Attribute
     * @param dexterity The Dexterity you want to set
     */
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    /**
     * Gets the Intelligence Attribute
     * @return The Intelligence Attribute
     */
    public int getIntelligence() {
        return intelligence;
    }

    /**
     * Sets the Intelligence Attribute
     * @param intelligence The Intelligence you want to set
     */
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    /**
     * Gets the Wisdom Attribute
     * @return The Wisdom Attribute
     */
    public int getWisdom() {
        return wisdom;
    }

    /**
     * Sets the Wisdom Attribute
     * @param wisdom The Wisdom you want to set
     */
    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    /**
     * Gets the Charisma Attribute
     * @return The Charisma Attribute
     */
    public int getCharisma() {
        return charisma;
    }

    /**
     * Sets the Charisma Attribute
     * @param charisma The Charisma you want to set
     */
    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }
}
