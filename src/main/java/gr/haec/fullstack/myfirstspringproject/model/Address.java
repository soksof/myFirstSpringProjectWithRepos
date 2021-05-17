package gr.haec.fullstack.myfirstspringproject.model;


import javax.persistence.*;

@Entity
public class Address {
    @Id
    private int id;
    private String streetName;
    private String streetNumber;
    private int floor;
    private String city;
    private String poBox;

    public Address(){

    }
    public Address(String streetName, String streetNumber, int floor, String city, String poBox) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.floor = floor;
        this.city = city;
        this.poBox = poBox;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPoBox() {
        return poBox;
    }

    public void setPoBox(String poBox) {
        this.poBox = poBox;
    }
}
