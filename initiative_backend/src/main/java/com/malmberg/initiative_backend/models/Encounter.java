package com.malmberg.initiative_backend.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "encounter")
public class Encounter {
    @Id
    @Column(name="eid", nullable=false, length=64)
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(name="name", nullable=false, length=50)
    private String name;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="uid")
    private User owner;

    @OneToMany
    private List<Creature> combatants = new ArrayList<Creature>();

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

    public List<Creature> getCombatants() {
        return combatants;
    }

    public void setCombatants(List<Creature> combatants) {
        this.combatants = combatants;
    }
}
