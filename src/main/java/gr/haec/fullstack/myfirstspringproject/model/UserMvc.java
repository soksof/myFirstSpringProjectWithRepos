package gr.haec.fullstack.myfirstspringproject.model;

public class UserMvc{
    private int id;
    private String name;
    private String email;
    private String lastName;
    private String password;
    private String passwordRepeat;
    private String streetName;
    private String streetNumber;
    private int floor;
    private String city;
    private String poBox;

    public UserMvc(){

    }

    public UserMvc(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.lastName = user.getLastName();
        this.password = user.getPassword();
        this.passwordRepeat = user.getPasswordRepeat();
        this.streetName = user.getAddress().getStreetName();
        this.streetNumber = user.getAddress().getStreetNumber();
        this.floor = user.getAddress().getFloor();
        this.city = user.getAddress().getCity();
        this.poBox = user.getAddress().getPoBox();
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
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
