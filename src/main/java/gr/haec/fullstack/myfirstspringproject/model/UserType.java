package gr.haec.fullstack.myfirstspringproject.model;

import javax.persistence.*;

@Entity
public class UserType {
    @Id
    @GeneratedValue
    private int id;
    @Column(unique = true)
    private String type;

    public UserType(){

    }

    public UserType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
