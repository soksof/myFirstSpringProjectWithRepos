package gr.haec.fullstack.myfirstspringproject.model;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    private String lastName;
    private String password;
    @Transient
    private String passwordRepeat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
