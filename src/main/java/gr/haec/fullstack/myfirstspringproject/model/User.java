package gr.haec.fullstack.myfirstspringproject.model;

import javax.persistence.*;
import java.util.List;

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
    @ManyToOne
    private Address address;

    public User(){

    }

    public User(UserMvc user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.lastName = user.getLastName();
        this.password = user.getPassword();
        this.passwordRepeat = user.getPasswordRepeat();
        this.address = new Address(user.getStreetName(), user.getStreetNumber(), user.getFloor(), user.getCity(),
                user.getPoBox());
    }

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
