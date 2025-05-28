package citi_demo_package.model;

/** A felhasználó  osztály létrehozása*/
public class User {
    private long id;
    private String name;
    private String email;
    private String country;
    /** konstruktorok*/
    public User() {}
    /** Első konstruktor id nélkül, mert létrehozáskor létre kell hozni*/
    public User(String name, String email, String country) {
        this.name = name;
        this.email = email;
        this.country = country;
    }
    /**Második konstruktor, beolvasáshoz*/
    public User(int id, String name, String email, String country) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
    }

    /**Getterek és szetterek, lombok-al még barátkozok*/
    public int getId() { return Math.toIntExact(id); }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    /** Kiírás konzolba*/
    @Override
    public String toString() {
        return "User{id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
