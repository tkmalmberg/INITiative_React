package com.malmberg.initiative_backend.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user")
public class User {
    @Id
    @Column(name="uid", updatable=false, nullable=false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="fname", length=50)
    private String firstName;

    @Column(name="lname", length=50)
    private String lastName;

    @Column(name="email", nullable=false, length=50)
    private String email;

    @Column(name="password", nullable=false, length=50)
    private String pass;

    @Column(name="admin", nullable=false)
    private boolean admin;

    @OneToMany(mappedBy="owner")
    private List<Encounter> encounters = null;

    @OneToMany(mappedBy="player")
    private List<PlayerCharacter> pcs = null;

    public User() {
        super();
    }

    /**
     * @param email User's email
     * @param pass User's password
     * @param admin User's admin status
     */
    public User(String email, String pass, boolean admin) {
        super();
        this.email = email;
        this.pass = pass;
        this.admin = admin;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the fName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param fName the fName to set
     */
    public void setFirstName(String fName) {
        this.firstName = fName;
    }

    /**
     * @return the lName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lName the lName to set
     */
    public void setLastName(String lName) {
        this.lastName = lName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the admin
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * @param admin the admin to set
     */
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    /**
     * @return the encounters
     */
    public List<Encounter> getEncounters() {
        return encounters;
    }

    /**
     * @param encounters the encounters to set
     */
    public void setEncounters(List<Encounter> encounters) {
        this.encounters = encounters;
    }

    public List<PlayerCharacter> getPcs() {
        return pcs;
    }

    public void setPcs(List<PlayerCharacter> pcs) {
        this.pcs = pcs;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", admin=" + admin +
                '}';
    }
}
