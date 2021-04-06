package com.malmberg.initiative_backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jmx.export.annotation.ManagedAttribute;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "monster")
public class Monster extends Creature {
    @Column(name="name")
    private String name;

    @Column(name="hitPoints")
    private int hitPoints;

    public Monster(String name, int hitPoints) {
        this.name = name;
        this.hitPoints = hitPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
}
