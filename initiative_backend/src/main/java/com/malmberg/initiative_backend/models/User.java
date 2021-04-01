package com.malmberg.initiative_backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="user")
public class User {
    //public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
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
    private @JsonIgnore String pass;

    public void setPass(String pass) {
        this.pass = pass; //PASSWORD_ENCODER.encode(pass);
    }

    @Column(name="admin", nullable=false)
    private @JsonIgnore boolean admin;

    @OneToMany(mappedBy="owner")
    private List<Encounter> encounters;

    @OneToMany
    private List<PlayerCharacter> pcs;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return admin == user.admin && Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && email.equals(user.email) && pass.equals(user.pass);
    }

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
