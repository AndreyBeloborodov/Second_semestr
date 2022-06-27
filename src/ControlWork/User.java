package ControlWork;

public class User {
    int id;
    String name;
    int year;
    String city;
    int countFavourite;

    public User(int id, String name, int year, String city) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.city = city;
        countFavourite = 0;
    }

}
