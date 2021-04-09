package com.malmberg.initiative_backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * The User class models what a user will need for functionality in the
 * INITiative application
 */
@Entity
@Table(name="user")
public class User implements Serializable {
    //public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
    /**
     * The ID of the User
     */
    @Id
    @Column(name="uid", updatable=false, nullable=false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    /**
     * First Name of the User
     */
    @Column(name="fname", length=50)
    private String firstName;

    /**
     * Last Name of the User
     */
    @Column(name="lname", length=50)
    private String lastName;

    /**
     * Email of the User
     */
    @Column(name="email", nullable=false, length=50)
    private String email;

    /**
     * Password of the User
     */
    @Column(name="password", nullable=false, length=50)
    private String pass;

    /**
     * Admin Status of the User
     */
    @Column(name="admin")
    private @JsonIgnore boolean admin;

//    @OneToMany(mappedBy="owner")
//    @JsonManagedReference
//    private List<Encounter> encounters;

//    @ManyToMany(cascade = {CascadeType.ALL})
//    @JoinTable(
//            name ="user_pcs",
//            joinColumns = {@JoinColumn(name = "uid")},
//            inverseJoinColumns = {@JoinColumn(name = "creature_id")}
//    )
//    private List<PlayerCharacter> pcs;

    /**
     * Empty constructor for the User class
     */
    public User() {
        super();
    }

    /**
     * Constructor for the User class
     * @param email User's email
     * @param pass User's password
     */
    public User(String email, String pass) {
        super();
        this.email = email;
        this.pass = pass;
    }

    /**
     * Compares instance of a User to another object and determines equality
     * based on the parameters of the class
     * @param o The Object to be compared to
     * @return Boolean of whether the objects are equal or not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return admin == user.admin && Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && email.equals(user.email) && pass.equals(user.pass);
    }

    /**
     * Hash code function for the class
     * @return HashCode of the User
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, pass, admin);
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
     * Sets the Password of the User
     * @param pass The password you want to set
     */
    public void setPass(String pass) {
        this.pass = pass; //PASSWORD_ENCODER.encode(pass);
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

//    /**
//     * @return the encounters
//     */
//    public List<Encounter> getEncounters() {
//        return encounters;
//    }
//
//    /**
//     * @param encounters the encounters to set
//     */
//    public void setEncounters(List<Encounter> encounters) {
//        this.encounters = encounters;
//    }
//
//    public List<PlayerCharacter> getPcs() {
//        return pcs;
//    }
//
//    public void setPcs(List<PlayerCharacter> pcs) {
//        this.pcs = pcs;
//    }

    /**
     * Prints the User as a String
     * @return Built string of the User class
     */
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
