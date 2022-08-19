package ru.netology.MyJavaLessonTournament;

public class Player {

    protected int id;
    protected String name;
    protected int strength;

    public Player(int id, String name, int strength) {
        this.id = id;
        this.name = name;
        this.strength = strength;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public int getStrength() {
        return strength;
    }

//    public void setStrength(int strength) {
//        this.strength = strength;
//    }
}