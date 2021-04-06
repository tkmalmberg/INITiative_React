package com.malmberg.initiative_backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "player_character")
public class PlayerCharacter extends Creature implements Serializable{
    @Column(name="name")
    private String name = "";

    @Column(name="race")
    private String race = "";

    @Column(name="class")
    private String className = "";

    @Column(name="hitPoints")
    private int hitPoints = 0;

    @Column(name="charLevel")
    private int level = 0;

    @ManyToMany(mappedBy = "pcs")
    @JsonProperty
    private List<User> player;

    public PlayerCharacter() {
    }

    public PlayerCharacter(String name, String race, String className, int hitPoints, int level) {
        this.name = name;
        this.race = race;
        this.className = className;
        this.hitPoints = hitPoints;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<User> getPlayer() {
        return player;
    }

    public void setPlayer(List<User> player) {
        this.player = player;
    }
}
