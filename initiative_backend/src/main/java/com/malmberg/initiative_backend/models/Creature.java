package com.malmberg.initiative_backend.models;

import javax.persistence.*;

@Entity
@Table(name = "creature")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Creature {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="eid", updatable=false, nullable=false)
    protected Long id;

    @Column(name="strength")
    protected int strength = 10;

    @Column(name="constitution")
    protected int constitution = 10;

    @Column(name="dexterity")
    protected int dexterity = 10;

    @Column(name="intelligence")
    protected int intelligence = 10;

    @Column(name="wisdom")
    protected int wisdom = 10;

    @Column(name="charisma")
    protected int charisma = 10;

    public Creature() { }

    public Creature(int strength, int constitution, int dexterity, int intelligence, int wisdom, int charisma) {
        this.strength = strength;
        this.constitution = constitution;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    public Long getId() {
        return id;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }
}
