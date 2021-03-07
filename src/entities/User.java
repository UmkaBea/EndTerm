package entities;

public class User {
    protected int id;           // ID of every person related to library
    protected String password;  // Password of every person related to library
    protected String userName;  // NickName of every person related to library
    protected int age;          // Age of person
    protected String name;      // Name of User
    protected String surname;   // Surname of User
    protected String email;     // Email address of User

    // Constructor that contains all data of User
    public User(int id, String name, String surname, int age, String userName, String password, String email){
        setId(id);
        setName(name);
        setSurname(surname);
        setAge(age);
        setUserName(userName);
        setPassword(password);
        setEmail(email);
    }

    // Constructor that contains name,surname,age,username or nickname, password and email of User
    public User(String name, String surname, int age, String userName, String password, String email){
        setName(name);
        setSurname(surname);
        setAge(age);
        setUserName(userName);
        setPassword(password);
        setEmail(email);
    }

    // Constructor that contains only userName and password
    public User(String userName, String password){
        setUserName(userName);
        setPassword(password);
    }

    // Getter and Setter functions
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Method to override all users in DBMS
    @Override
    public String toString() {
        return id + " | " + name +
                " | " + surname + " | " + age +
                " | " + password +" | "+ userName + " | " + email + "\n";
    }
}
